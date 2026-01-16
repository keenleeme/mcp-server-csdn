package cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto;

import lombok.Data;

@Data
public class ArticleResponseDTO {

    private Integer code;

    private String traceId;

    private ArticleData data;

    private String msg;

}

