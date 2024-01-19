package com.jeju.main.domain.guesthouse.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.jeju.main.domain.guesthouse.dto.response.GuestHouseResponseDto;
import com.jeju.main.domain.guesthouse.service.GuestHouseService;
import com.jeju.main.global.common.SuccessResponse;
import java.io.IOException;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guesthouse")
@PropertySource("classpath:application.yml")
public class GuestHouseController {
    @Autowired
    private final GuestHouseService guestHouseService;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3Client amazonS3Client;
    @GetMapping("{id}")
    public ResponseEntity<SuccessResponse<?>> searchGuestHouse(@PathVariable("id") Long guestHouseId){
        GuestHouseResponseDto guestHouseResponseDto = guestHouseService.getGuestHouse(guestHouseId);
        return SuccessResponse.ok(guestHouseResponseDto);
    }
    @PostMapping("")
    public ResponseEntity<SuccessResponse<?>> createGuest(@RequestBody GuestHouseResponseDto guestHouseResponseDto,
                                                          MultipartFile file) throws IOException{

        try {
            String image = file.getOriginalFilename();
            String url= "https://" + bucket + "/test" +image;
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket,image,file.getInputStream(),metadata);
            guestHouseService.addGuestHouse(guestHouseResponseDto,url);
            return SuccessResponse.created(null);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/region")
    public ResponseEntity<SuccessResponse<?>> searchByRegionGuestHouses(@RequestParam("region") String region){
        List<GuestHouseResponseDto> guestHouseResponseDtos = guestHouseService.getByRegionGuestHouses(region);

        return SuccessResponse.ok(guestHouseResponseDtos);
    }
}
