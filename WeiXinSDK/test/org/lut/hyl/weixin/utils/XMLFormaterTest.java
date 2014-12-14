package org.lut.hyl.weixin.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.lut.hyl.weixin.model.response.ResponseMessage;
import org.lut.hyl.weixin.model.response.ResponseMusicMessage;
import org.lut.hyl.weixin.model.response.ResponseNewsMessage;
import org.lut.hyl.weixin.model.response.ResponseTextMessage;
import org.lut.hyl.weixin.model.response.ResponseMusicMessage.Music;
import org.lut.hyl.weixin.model.response.ResponseNewsMessage.Article;

public class XMLFormaterTest {

	@Test
	public void testFormatResponseMessage() {
		ResponseMessage message = new ResponseTextMessage("to", "from",
				new Date().getTime(), 0, "hello");
		System.out.println(new XMLFormater().format(message));
		// System.out.println(new XMLFormater().format(message));
	}

	@Test
	public void testFormatResponseMessage2() {
		ResponseNewsMessage message = new ResponseNewsMessage();
		message.setToUserName("to");
		message.setFromUserName("from");
		message.setFuncFlag(0);
		message.setCreateTime(new Date().getTime());
		List<Article> articles = new ArrayList<ResponseNewsMessage.Article>();
		articles.add(new Article("t", "ds", "http", "ufks"));
		articles.add(new Article("ts", "ds", "http", "ufks"));
		message.setArticleCount(articles.size());
		message.setArticles(articles);
		System.out.println(new XMLFormater().format(message));
		// System.out.println(new XMLFormater().format(message));
	}

	@Test
	public void test3() {
		ResponseMusicMessage message = new ResponseMusicMessage();
		message.setCreateTime(new Date().getTime());
		message.setFromUserName("fff");
		message.setToUserName("ttt");
		message.setFuncFlag(0);

		Music music = new Music("tm", "dm", "um", "hm", "thm");
		message.setMusic(music);

		System.out.println(new XMLFormater().format(message));
	}

}
