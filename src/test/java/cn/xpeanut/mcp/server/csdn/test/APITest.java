package cn.xpeanut.mcp.server.csdn.test;

import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionRequest;
import cn.xpeanut.mcp.server.csdn.domain.model.ArticleFunctionResponse;
import cn.xpeanut.mcp.server.csdn.domain.service.CSDNArticleService;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.ICSDNService;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto.ArticleRequestDTO;
import cn.xpeanut.mcp.server.csdn.infrastructure.gateway.dto.ArticleResponseDTO;
import cn.xpeanut.mcp.server.csdn.type.utils.MarkdownConverter;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class APITest {

    private final Logger log = LoggerFactory.getLogger(APITest.class);

    @Autowired
    private ICSDNService csdnService;

    @Autowired
    private CSDNArticleService csdnArticleService;

    @Test
    public void testSaveArticle() throws IOException {
        // 1. 构建请求对象
        ArticleRequestDTO request = new ArticleRequestDTO();
        request.setTitle("测试文章标题01");
        request.setMarkdownContent("# 测试文章内容\n这是一篇测试文章");
        request.setContent("<h1>测试文章内容</h1><p>这是一篇测试文章</p>");
        request.setReadType("public");
        request.setLevel("0");
        request.setTags("测试,文章");
        request.setStatus(0);
        request.setCategories("后端");
        request.setType("original");
        request.setOriginalLink("");
        request.setAuthorizedStatus(true);
        request.setDescription("这是一篇测试文章的描述");
        request.setResourceUrl("");
        request.setNotAutoSaved("0");
        request.setSource("pc_mdeditor");
        request.setCoverImages(Collections.emptyList());
        request.setCoverType(0);
        request.setIsNew(1);
        request.setVoteId(0);
        request.setResourceId("");
        request.setPubStatus("draft");
        request.setSyncGitCode(0);

        // 2. 调用接口
        String cookie = "uuid_tt_dd=10_19420161830-1744356347056-935909; fid=20_08826086389-1744356348602-337168; UN=qq5621; __gads=ID=8ed3124ac76411f0:T=1744356348:RT=1754296346:S=ALNI_MaIgZKYYl9j5m3D7QlHxoCflNrxLQ; __gpi=UID=00001099276b43ec:T=1744356348:RT=1754296346:S=ALNI_MYDZ01hpqYfs7YzemNsJt2m7QkcPQ; FCNEC=%5B%5B%22AKsRol8COHJiRxlPJBY7_Uj-9Yqui5jFnilG02Xw6SVlwMI6jmfZrFQNV6LIs_DJhOT-PrPKjRh8re5RS5dqVdYb8lXyfQkTxm7mxoyrVwIztJLx4zz1rzagV_xpe6Q9hZwX7WyAffq0lH4LlukjACOm5Q6g53KOkA%3D%3D%22%5D%5D; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=6525*1*10_19420161830-1744356347056-935909!5744*1*qq5621; c_dl_prid=1754969326061_446946; c_dl_rid=1760161801388_606374; c_dl_fref=https://bbs.csdn.net/topics/604414946; c_dl_fpage=/download/li514006030/77346010; c_dl_um=-; p_uid=U010000; csdn_newcert_qq5621=1; _clck=1h56xk5%5E2%5Eg2i%5E0%5E1927; UserName=qq5621; UserInfo=3637f0b6c5524c3ca23a601d0b3a01f7; UserToken=3637f0b6c5524c3ca23a601d0b3a01f7; UserNick=%E5%83%8F%E5%B0%91%E5%B9%B4%E5%95%A6%E9%A3%9E%E9%A9%B0%E7%82%B9%E3%80%81; AU=F0F; BT=1767777722906; dc_session_id=10_1768465557544.387315; c_first_ref=default; c_first_page=https%3A//www.csdn.net/; c_dsid=11_1768465557838.840031; c_segment=5; c-sidebar-collapse=0; c_ab_test=1; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1767750954,1768360953,1768465559; HMACCOUNT=F59821951BDC5696; dc_sid=e85434ce8ae45ba392af1dbf11014b47; creative_popup=%7B%22arrowIcon%22%3A%22https%3A//i-operation.csdnimg.cn/images/9a154de8dd9a4f9d82b854213f4c9aec.png%22%2C%22img%22%3A%22https%3A//i-operation.csdnimg.cn/images/4beaf483366f4bb499fa210046cef1a8.png%22%2C%22imgStyle%22%3A%22height%3A%2088px%3B%22%2C%22darkCfg%22%3A%7B%7D%2C%22role%22%3A%22lost%22%2C%22report%22%3A%7B%22spm%22%3A%223001.11122%22%2C%22extra%22%3A%22%22%7D%2C%22style%22%3A%22%22%2C%22arrowIconStyle%22%3A%22%22%2C%22url%22%3A%22https%3A//www.csdn.net/cps/2025summary/%3Futm_source%3D1510165626%22%2C%22newTab%22%3Afalse%2C%22userName%22%3A%22qq5621%22%7D; creative_btn_mp=1; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1768465597; c_pref=https%3A//www.csdn.net/; c_ref=https%3A//editor.csdn.net/; c_page_id=default; log_Id_pv=3; log_Id_view=100; log_Id_click=4; dc_tos=t8wcx9";
        Call<ArticleResponseDTO> call = csdnService.saveArticle(request, cookie);
        Response<ArticleResponseDTO> response = call.execute();

        System.out.println("\r\n测试结果" + JSON.toJSONString(response));

        // 3. 验证结果
        if (response.isSuccessful()) {
            ArticleResponseDTO articleResponseDTO = response.body();
            log.info("发布文章成功 {}", articleResponseDTO);
        }
    }

    @Test
    public void test_md2html() {
        System.out.println(MarkdownConverter.convertToHtml("**关于DDD是什么，在维基百科有一个明确的定义。\"Domain-driven design (DDD) is a major software design approach.\" 也就是说DDD是一种主要的软件设计方法。而软件设计涵盖了；范式、模型、框架、方法论。**\n" +
                "\n" +
                "- 范式（paradigm）指的是一种编程思想。\n" +
                "- 模型（model）指的是对现实世界或者问题的抽象描述。\n" +
                "- 框架（framework）指的是提供了一系列通用功能和结构的软件工具。\n" +
                "- 方法论（methodology）指的是一种系统的、有组织的解决问题的方法。\n" +
                "\n" +
                "所以，DDD不只是只有指导思想，伴随的DDD的还包括框架结构分层。但说到底，这些仍然是理论讨论。在没有一个DDD落地项目物参考下，其实大部分码农是没法完成DDD开发的。所以小傅哥今年花费了5个月假期/周末的时间，完成的《DDD简明开发教程》，帮助大家落地DDD编码。"));
    }

    @Test
    public void test_saveArticle() throws IOException {
        String json = "{\"content\":\"<h2>场景：</h2>\\n<p>在某互联网大厂的面试室，一位严肃的面试官正准备提问，而对面坐着一位看似紧张却又想显得轻松的程序员小张。</p>\\n<p><strong>面试官</strong>：我们先来聊聊Java核心知识。第一个问题，Java中的JVM是如何管理内存的？</p>\\n<p><strong>程序员小张</strong>：哦，这个简单！JVM就像一个巨大的购物车，负责把所有的变量都放进去，呃……然后就……管理起来？</p>\\n<p><strong>面试官</strong>：嗯，第二个问题，请说说HashMap的工作原理。</p>\\n<p><strong>程序员小张</strong>：HashMap嘛，就是……呃，一个很大的箱子，大家都往里面扔东西，有时候会打架……</p>\\n<p><strong>面试官</strong>：那么第三个问题，能不能讲讲Spring和SpringBoot的区别？</p>\\n<p><strong>程序员小张</strong>：Spring是……呃，春天？SpringBoot就是穿靴子的春天嘛！哈哈……</p>\\n<p><strong>面试官</strong>：好，今天的问题就问到这里。回去等通知吧。</p>\\n<h2>答案解析：</h2>\\n<ol>\\n<li>\\n<p><strong>JVM内存管理</strong>：JVM内存管理包括堆内存和栈内存，堆内存用于存储对象实例，栈内存用于执行线程时的栈帧。</p>\\n</li>\\n<li>\\n<p><strong>HashMap原理</strong>：HashMap通过哈希函数将键映射到对应的值，并通过链表解决哈希冲突。</p>\\n</li>\\n<li>\\n<p><strong>Spring与SpringBoot区别</strong>：Spring是一个大型应用框架，而SpringBoot是基于Spring的快速开发套件，简化了Spring应用的配置。</p>\\n</li>\\n</ol>\\n\",\"cover_images\":[],\"cover_type\":0,\"description\":\"在互联网大厂的面试中，严肃的面试官与搞笑的程序员上演了一场精彩的对话。面试官提出Java核心知识、HashMap、Spring等问题，程序员则用幽默的方式作答。本文不仅展现了轻松的面试氛围，还附上了详细的技术问题答案解析，帮助读者更好地理解相关知识。\",\"is_new\":1,\"level\":\"0\",\"markdowncontent\":\"## 场景：\\n\\n在某互联网大厂的面试室，一位严肃的面试官正准备提问，而对面坐着一位看似紧张却又想显得轻松的程序员小张。\\n\\n**面试官**：我们先来聊聊Java核心知识。第一个问题，Java中的JVM是如何管理内存的？\\n\\n**程序员小张**：哦，这个简单！JVM就像一个巨大的购物车，负责把所有的变量都放进去，呃……然后就……管理起来？\\n\\n**面试官**：嗯，第二个问题，请说说HashMap的工作原理。\\n\\n**程序员小张**：HashMap嘛，就是……呃，一个很大的箱子，大家都往里面扔东西，有时候会打架……\\n\\n**面试官**：那么第三个问题，能不能讲讲Spring和SpringBoot的区别？\\n\\n**程序员小张**：Spring是……呃，春天？SpringBoot就是穿靴子的春天嘛！哈哈……\\n\\n**面试官**：好，今天的问题就问到这里。回去等通知吧。\\n\\n## 答案解析：\\n\\n1. **JVM内存管理**：JVM内存管理包括堆内存和栈内存，堆内存用于存储对象实例，栈内存用于执行线程时的栈帧。\\n\\n2. **HashMap原理**：HashMap通过哈希函数将键映射到对应的值，并通过链表解决哈希冲突。\\n\\n3. **Spring与SpringBoot区别**：Spring是一个大型应用框架，而SpringBoot是基于Spring的快速开发套件，简化了Spring应用的配置。\",\"not_auto_saved\":\"0\",\"pubStatus\":\"draft\",\"readType\":\"public\",\"resource_id\":\"\",\"resource_url\":\"\",\"source\":\"pc_mdeditor\",\"status\":0,\"sync_git_code\":0,\"tags\":\"Java,面试,互联网,程序员,Spring,SpringBoot,HashMap,JVM\",\"title\":\"互联网大厂Java面试：严肃面试官与搞笑程序员的对决\",\"vote_id\":0}";
        ArticleFunctionRequest request = JSON.parseObject(json, ArticleFunctionRequest.class);
        ArticleFunctionResponse response = csdnArticleService.saveArticle(request);
        log.info("测试结果：{}", JSON.toJSONString(response));
    }

}

