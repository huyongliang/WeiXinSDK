package org.lut.hyl.weixin.model.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ResponseNewsMessage extends ResponseMessage {
	protected int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	protected List<Article> Articles;

	public ResponseNewsMessage() {
		super();
		this.msgType = ResponseMessageType.NEWS;
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	@XStreamAlias("item")
	public static class Article {
		// 图文消息名称
		@XStreamAlias("Title")
		private String title;
		// 图文消息描述
		private String description;
		// 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
		@XStreamAlias("PicUrl")
		private String picUrl;
		// 点击图文消息跳转链接
		@XStreamAlias("Url")
		private String url;

		public Article() {
			super();
		}

		public Article(String title, String description, String picUrl,
				String url) {
			super();
			this.title = title;
			this.description = description;
			this.picUrl = picUrl;
			this.url = url;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPicUrl() {
			return picUrl;
		}

		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

}
