package org.lut.hyl.weixin.model.response;

public class ResponseMusicMessage extends ResponseMessage {
	public ResponseMusicMessage() {
		super();
		this.msgType = ResponseMessageType.MUSIC;
	}

	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public static class Music {
		// ��������
		private String Title;
		// ��������
		private String Description;
		// ��������
		private String MusicUrl;
		// �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
		private String HQMusicUrl;
		// ����ͼ��ý��id��ͨ���ϴ���ý���ļ����õ���id
		private String ThumbMediaId;

		public Music() {
			super();
		}

		public Music(String title, String description, String musicUrl,
				String hQMusicUrl, String thumbMediaId) {
			super();
			Title = title;
			Description = description;
			MusicUrl = musicUrl;
			HQMusicUrl = hQMusicUrl;
			ThumbMediaId = thumbMediaId;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getMusicUrl() {
			return MusicUrl;
		}

		public void setMusicUrl(String musicUrl) {
			MusicUrl = musicUrl;
		}

		public String getHQMusicUrl() {
			return HQMusicUrl;
		}

		public void setHQMusicUrl(String hQMusicUrl) {
			HQMusicUrl = hQMusicUrl;
		}

		public String getThumbMediaId() {
			return ThumbMediaId;
		}

		public void setThumbMediaId(String thumbMediaId) {
			ThumbMediaId = thumbMediaId;
		}

		@Override
		public String toString() {
			return "Music [Title=" + Title + ", Description=" + Description
					+ ", MusicUrl=" + MusicUrl + ", HQMusicUrl=" + HQMusicUrl
					+ ", ThumbMediaId=" + ThumbMediaId + "]";
		}

	}

	@Override
	public String toString() {
		return "ResponseMusicMessage [music=" + music + ", toUserName="
				+ toUserName + ", fromUserName=" + fromUserName
				+ ", createTime=" + createTime + ", msgType=" + msgType
				+ ", funcFlag=" + funcFlag + "]";
	}

}
