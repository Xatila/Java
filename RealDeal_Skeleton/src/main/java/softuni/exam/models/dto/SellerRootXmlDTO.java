package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerRootXmlDTO {

    @XmlElement(name = "seller ")
    private List<SellerSeedXmlDTO> sellerSeedXmlDTOList;

    public List<SellerSeedXmlDTO> getSellerSeedXmlDTOList() {
        return sellerSeedXmlDTOList;
    }

    public void setSellerSeedXmlDTOList(List<SellerSeedXmlDTO> sellerSeedXmlDTOList) {
        this.sellerSeedXmlDTOList = sellerSeedXmlDTOList;
    }
}
