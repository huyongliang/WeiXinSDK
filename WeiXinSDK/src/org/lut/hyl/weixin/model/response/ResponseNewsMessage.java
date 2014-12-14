package org.lut.hyl.weixin.model.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class ResponseNewsMessage extends ResponseMessage {
	protected int ArticleCount;
	// ����ͼ����Ϣ��Ϣ��Ĭ�ϵ�һ��itemΪ��ͼ
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
		// ͼ����Ϣ����
		@XStreamAlias("Title")
		private String title;
		// ͼ����Ϣ����
		private String description;
		// ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ640*320��Сͼ80*80������ͼƬ���ӵ�������Ҫ�뿪������д�Ļ��������е�Urlһ��
		@XStreamAlias("PicUrl")
		private String picUrl;
		// ���ͼ����Ϣ��ת����
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
