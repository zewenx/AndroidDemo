package zeven.vo;

/**
 * 类描述：
 * 创建人：zeven
 * 创建时间：16/4/13 下午2:49
 */
public class PicasooVO extends BaseVO {
    boolean clicked = true;
    String url ;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
