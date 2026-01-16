package cn.xpeanut.mcp.server.csdn.domain.service;

import cn.xpeanut.mcp.server.csdn.domain.adapter.ICSDNPort;
import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionResponse;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CSDNArticleService {

    private final static Logger log = LoggerFactory.getLogger(CSDNArticleService.class);

    @Resource
    private ICSDNPort csdnPort;

    @Tool(description = "发布文章到CSDN")
    public ArticleFunctionResponse saveArticle(ArticleFunctionRequest request) throws IOException {
        log.info("CSDN发帖，标题：{}，内容简述：{}， 标签：{}", request.getTitle(), request.getDescription(), request.getTags());
        return csdnPort.writeArticle(request);
    }

}
