package cn.jiande.util.Beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 
* @author	longjie 
* @mail 	httpsession@qq.com
* @date 	2018年5月1日 上午10:25:00 
*/
public class CommonQo {
	private  int pageNum = 1;

    private int pageSize = 10;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sinceTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Date getSinceTime() {
        return sinceTime;
    }

    public void setSinceTime(Date sinceTime) {
        this.sinceTime = sinceTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CommonQo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", sinceTime=" + sinceTime +
                ", endTime=" + endTime +
                '}';
    }
}
