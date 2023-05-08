package com.app.api.login.dto;

import com.app.global.jwt.dto.JwtTokenDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

public class OauthLoginDto {

    @Getter
    @Setter
    public static class Request {
        @Schema(description = "소셜 로그인 회원 타입", example = "KAKAO", required = true)
        private String memberType;
    }

    @Getter
    @Setter
    @Builder @NoArgsConstructor @AllArgsConstructor
    public static class Response {

        @Schema(description = "grantType", example = "Bearer", required = true)
        private String grantType;

        @Schema(description = "accessToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQ0NFU1MiLCJpYXQiOjE2NjcwNTQ3NzgsImV4cCI6MTY2NzA1NTY3OCwibWVtYmVySWQiOjEsInJvbGUiOiJBRE1JTiJ9.V4vMye2vXaUyYzvYtM_3L8-ZjudKz7j2azNj-FMjKQu7tZx_FxfSN2lfAOYx4uRTo8vYB9qweqeqwZaa4RuZAcs7oQ", required = true)
        private String accessToken;

        @Schema(description = "refreshToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSRUZSRVNIIiwiaWF0IjoxNjY3MDU0Nzc4LCJleHAiOjE2NjgyNjQzNzgsIm1lbWJlcklkIjoxfQ.0h7uEFUVx3Ur8dezv47iRIZiJEk8CwgL6s11SbfhEolVL3ZWY3xqmcbHrrxp1pODyAa1hnvac-NY5GnYUIWasdqwefsdf", required = true)
        private String refreshToken;

        @Schema(description = "access token 만료 시간", example = "2022-10-30 00:01:18", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date accessTokenExpireTime;

        @Schema(description = "refresh token 만료 시간", example = "2022-11-12 23:46:18", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date refreshTokenExpireTime;

        public static Response of(JwtTokenDto jwtTokenDto) {
            return Response.builder()
                    .grantType(jwtTokenDto.getGrantType())
                    .accessToken(jwtTokenDto.getAccessToken())
                    .accessTokenExpireTime(jwtTokenDto.getAccessTokenExpireTime())
                    .refreshToken(jwtTokenDto.getRefreshToken())
                    .refreshTokenExpireTime(jwtTokenDto.getRefreshTokenExpireTime())
                    .build();
        }
    }
}
