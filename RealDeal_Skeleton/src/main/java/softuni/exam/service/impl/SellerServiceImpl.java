package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerRootXmlDTO;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SellerServiceImpl implements SellerService {

    private static final String SELLER_XML_PATH = "src/main/resources/files/xml/sellers.xml";
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count()>0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_XML_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(SELLER_XML_PATH, SellerRootXmlDTO.class).getSellerSeedXmlDTOList();
        return null;
    }
}
