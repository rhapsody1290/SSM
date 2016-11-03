package cn.apeius.usermanage.domain;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Asus on 2016/11/2.
 */
@Table(name = "tb_resource")
public class Resource {
    @Id
    private Long id;
    private String resourceName;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
