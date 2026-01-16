package cn.xpeanut.mcp.server.csdn.domain.adapter;

import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionResponse;

import java.io.IOException;

public interface ICSDNPort {

    ArticleFunctionResponse writeArticle(ArticleFunctionRequest request) throws IOException;

}
