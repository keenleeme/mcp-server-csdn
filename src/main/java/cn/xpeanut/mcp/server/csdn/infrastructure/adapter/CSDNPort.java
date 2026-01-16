package cn.xpeanut.mcp.server.csdn.infrastructure.adapter;

import cn.xpeanut.mcp.server.csdn.domain.adapter.ICSDNPort;
import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionResponse;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.ICSDNService;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto.ArticleData;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto.ArticleRequestDTO;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto.ArticleResponseDTO;
import cn.xpeanut.mcp.server.csdn.type.properties.CSDNApiProperties;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
@Component
public class CSDNPort implements ICSDNPort {

    @Resource
    private ICSDNService csdnService;

    @Resource
    private CSDNApiProperties csdnApiProperties;

    @Override
    public ArticleFunctionResponse writeArticle(ArticleFunctionRequest request) throws IOException {
        ArticleRequestDTO articleRequestDTO = new ArticleRequestDTO()
                .setTitle(request.getTitle())
                .setMarkdownContent(request.getMarkdowncontent())
                .setContent(request.getContent())
                .setTags(request.getTags())
                .setDescription(request.getDescription())
                .setCategories(csdnApiProperties.getCategories());

        Call<ArticleResponseDTO> call = csdnService.saveArticle(articleRequestDTO, csdnApiProperties.getCookie());
        Response<ArticleResponseDTO> response = call.execute();

        log.info("请求CSDN发帖 \nreq: {} \nres:{}", articleRequestDTO.toString(), JSON.toJSONString(response));

        if (response.isSuccessful()) {
            ArticleResponseDTO articleResponseDTO = response.body();
            if (null == articleResponseDTO) {
                return null;
            }

            ArticleData articleData = articleResponseDTO.getData();
            return new ArticleFunctionResponse()
                    .setCode(articleResponseDTO.getCode())
                    .setMsg(articleResponseDTO.getMsg())
                    .setArticleData(ArticleFunctionResponse.ArticleData.builder()
                            .url(articleData.getUrl())
                            .id(articleData.getId())
                            .qrcode(articleData.getQrcode())
                            .title(articleData.getTitle())
                            .description(articleData.getDescription())
                            .build());
        }
        return null;
    }
}
