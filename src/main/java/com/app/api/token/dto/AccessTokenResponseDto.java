package com.app.api.token.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter @Builder
public class AccessTokenResponseDto {

    @Schema(description = "grantType", example = "Bearer", required = true)
    private String grantType;

    @Schema(description = "accessToken", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQ0NFU1MiLCJpYXQiOjE2NjcwNTQ3NzgsImV4cCI6MTY2NzA1NTY3OCwibWVtYmVySWQiOjEsInJvbGUiOiJBRE1JTiJ9.V4vMye2vXaUyYzvYtM_3L8-ZjudKz7j2azNj-FMjKQu7tZx_FxfSN2lfAOYx4uRTo8vYB9qweqeqwZaa4RuZAcs7oQ", required = true)
    private String accessToken;

    @Schema(description = "access token 만료 시간", example = "2022-10-30 00:01:18", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Date accessTokenExpireTime;

}
