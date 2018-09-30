package cn.roilat.study.libs.jaxb.demo2.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "graphMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class GraphMap {
    @XmlElementWrapper(name = "configs")
    @XmlElements({ @XmlElement(name = "insert", type = InsertConfig.class),
                   @XmlElement(name = "select", type = SelectConfig.class) })
    private List<GscOgmConfig> configs;

    public List<GscOgmConfig> getConfigs() {
        return configs;
    }

    @Override
    public String toString() {
        return "GraphMap [configs=" + configs + "]";
    }

}
