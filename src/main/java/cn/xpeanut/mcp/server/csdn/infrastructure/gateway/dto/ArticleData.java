package cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto;

import lombok.Data;

@Data
public class ArticleData {

    private String url;

    private Long id;

    private String qrcode;

    private String title;

    private String description;
}

