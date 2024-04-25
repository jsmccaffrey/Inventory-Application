package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (partRepository.count() == 0 && productRepository.count() == 0) {

            OutsourcedPart o1= new OutsourcedPart();
            o1.setCompanyName("NVIDIA");
            o1.setName("GPU Card");
            o1.setPrice(500.0);
            o1.setInv(25);
            o1.setMinInv(3);
            o1.setMaxInv(30);
            outsourcedPartRepository.save(o1);
            OutsourcedPart GPU=null;

            OutsourcedPart o2= new OutsourcedPart();
            o2.setCompanyName("AMD");
            o2.setName("CPU Chip");
            o2.setPrice(150.0);
            o2.setInv(30);
            o2.setMinInv(5);
            o2.setMaxInv(50);
            outsourcedPartRepository.save(o2);
            OutsourcedPart CPU=null;

            OutsourcedPart o3= new OutsourcedPart();
            o3.setCompanyName("Corsair");
            o3.setName("High Capacity RAM");
            o3.setPrice(200.0);
            o3.setInv(48);
            o3.setMinInv(4);
            o3.setMaxInv(60);
            outsourcedPartRepository.save(o3);
            OutsourcedPart RAM=null;

            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                System.out.println(part.getName()+" "+part.getCompanyName());
            }

            InhousePart i1= new InhousePart();
            i1.setName("Case Fans");
            i1.setId(100L);
            i1.setPrice(50.0);
            i1.setInv(80);
            i1.setMinInv(10);
            i1.setMaxInv(100);
            inhousePartRepository.save(i1);

            InhousePart i2= new InhousePart();
            i2.setName("RGB Lighting");
            i2.setId(100L);
            i2.setPrice(100.0);
            i2.setInv(24);
            i2.setMinInv(6);
            i2.setMaxInv(30);
            inhousePartRepository.save(i2);

            Product budgetComputer= new Product("Budget Computer",500.0,8);
            Product midRangeComputer= new Product("Mid-Range Computer",800.0,15);
            Product highEndComputer= new Product("High-End Computer",1000.0,8);
            Product gamingComputer= new Product("Gaming Computer",1200.0,12);
            Product workstationComputer = new Product("Workstation Computer",1500.0,5);
            productRepository.save(budgetComputer);
            productRepository.save(midRangeComputer);
            productRepository.save(highEndComputer);
            productRepository.save(gamingComputer);
            productRepository.save(workstationComputer);

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products: " + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts: " + partRepository.count());
            System.out.println(partRepository.findAll());
        } else {
            System.out.println("Inventory already exists. Skipping sample inventory addition.");
        }
    }
}
