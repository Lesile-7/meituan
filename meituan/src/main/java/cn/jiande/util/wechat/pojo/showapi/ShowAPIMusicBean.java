package cn.jiande.util.wechat.pojo.showapi;

import cn.jiande.util.BasePojo;

/** 
 * 
 * showAPI 接口返回音乐数据封装对象 针对音乐数据
* @author : MT
* @date 创建时间：2017年11月30日 下午3:37:38 
* @version 1.0 
*/
public class ShowAPIMusicBean extends BasePojo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 专辑id
	 */
	private String albumid;
	private String albummid;
	/**
	 * 专辑名
	 */
	private String albumname;
	/**
	 * 专辑大图
	 */
	private String albumpic_big;
	private String albumpic_small;
	/**
	 * 下载地址
	 */
	private String downUrl;
	/**
	 * 流媒体地址
	 */
	private String m4a;
	private String media_mid;
	private String strMediaMid;
	/**
	 * 歌曲ID
	 */
	private String songid;
	private String songmid;
	private String songname;
	private String singerid;
	private String singername;

	public ShowAPIMusicBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the albumid
	 */
	public String getAlbumid() {
		return albumid;
	}

	/**
	 * @param albumid the albumid to set
	 */
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}

	/**
	 * @return the albumname
	 */
	public String getAlbumname() {
		return albumname;
	}

	/**
	 * @param albumname the albumname to set
	 */
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}

	/**
	 * @return the albumpic_big
	 */
	public String getAlbumpic_big() {
		return albumpic_big;
	}

	/**
	 * @param albumpic_big the albumpic_big to set
	 */
	public void setAlbumpic_big(String albumpic_big) {
		this.albumpic_big = albumpic_big;
	}

	/**
	 * @return the albumpic_small
	 */
	public String getAlbumpic_small() {
		return albumpic_small;
	}

	/**
	 * @param albumpic_small the albumpic_small to set
	 */
	public void setAlbumpic_small(String albumpic_small) {
		this.albumpic_small = albumpic_small;
	}

	/**
	 * @return the downUrl
	 */
	public String getDownUrl() {
		return downUrl;
	}

	/**
	 * @param downUrl the downUrl to set
	 */
	public void setDownUrl(String downUrl) {
		this.downUrl = downUrl;
	}

	/**
	 * @return the m4a
	 */
	public String getM4a() {
		return m4a;
	}

	/**
	 * @param m4a the m4a to set
	 */
	public void setM4a(String m4a) {
		this.m4a = m4a;
	}

	/**
	 * @return the media_mid
	 */
	public String getMedia_mid() {
		return media_mid;
	}

	/**
	 * @param media_mid the media_mid to set
	 */
	public void setMedia_mid(String media_mid) {
		this.media_mid = media_mid;
	}

	/**
	 * @return the strMediaMid
	 */
	public String getStrMediaMid() {
		return strMediaMid;
	}

	/**
	 * @param strMediaMid the strMediaMid to set
	 */
	public void setStrMediaMid(String strMediaMid) {
		this.strMediaMid = strMediaMid;
	}

	/**
	 * @return the songid
	 */
	public String getSongid() {
		return songid;
	}

	/**
	 * @param songid the songid to set
	 */
	public void setSongid(String songid) {
		this.songid = songid;
	}

	/**
	 * @return the songname
	 */
	public String getSongname() {
		return songname;
	}

	/**
	 * @param songname the songname to set
	 */
	public void setSongname(String songname) {
		this.songname = songname;
	}

	/**
	 * @return the singerid
	 */
	public String getSingerid() {
		return singerid;
	}

	/**
	 * @param singerid the singerid to set
	 */
	public void setSingerid(String singerid) {
		this.singerid = singerid;
	}

	/**
	 * @return the singername
	 */
	public String getSingername() {
		return singername;
	}

	/**
	 * @param singername the singername to set
	 */
	public void setSingername(String singername) {
		this.singername = singername;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the albummid
	 */
	public String getAlbummid() {
		return albummid;
	}

	/**
	 * @param albummid the albummid to set
	 */
	public void setAlbummid(String albummid) {
		this.albummid = albummid;
	}

	/**
	 * @return the songmid
	 */
	public String getSongmid() {
		return songmid;
	}

	/**
	 * @param songmid the songmid to set
	 */
	public void setSongmid(String songmid) {
		this.songmid = songmid;
	}
}
