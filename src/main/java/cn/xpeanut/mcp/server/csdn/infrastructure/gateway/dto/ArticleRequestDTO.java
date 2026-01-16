package cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
public class ArticleRequestDTO {

    private String title;

    @JsonProperty("markdowncontent")
    private String markdownContent;

    private String content;

    private String readType = "public";

    private String level = "0";

    private String tags;

    private Integer status = 0;

    private String categories = "JavaAI学习路书";

    private String type = "original";

    @JsonProperty("original_link")
    private String originalLink = "";

    @JsonProperty("authorized_status")
    private Boolean authorizedStatus = true;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("resource_url")
    private String resourceUrl = "";

    @JsonProperty("not_auto_saved")
    private String notAutoSaved = "0";

    private String source = "pc_mdeditor";

    @JsonProperty("cover_images")
    private List<String> coverImages = Collections.emptyList();

    @JsonProperty("cover_type")
    private Integer coverType = 0;

    @JsonProperty("is_new")
    private Integer isNew = 1;

    @JsonProperty("vote_id")
    private Integer voteId = 0;

    @JsonProperty("resource_id")
    private String resourceId = "";

    @JsonProperty("pubStatus")
    private String pubStatus = "draft";

    @JsonProperty("sync_git_code")
    private Integer syncGitCode = 0;

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", readType='" + readType + '\'' +
                ", tags='" + tags + '\'' +
                ", status=" + status +
                ", categories='" + categories + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", isNew=" + isNew +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}

