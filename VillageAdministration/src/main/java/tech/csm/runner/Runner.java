package tech.csm.runner;

import java.util.List;
import java.util.Scanner;

import tech.csm.entity.Block;
import tech.csm.entity.Panchayat;
import tech.csm.entity.Village;
import tech.csm.service.BlockService;
import tech.csm.service.BlockServiceImpl;
import tech.csm.service.PanchayatService;
import tech.csm.service.PanchayatServiceImpl;
import tech.csm.service.VillageService;
import tech.csm.service.VillageServiceImpl;
import tech.csm.util.DBUtil;

public class Runner {
	private static BlockService  blockService = new BlockServiceImpl();
	private static PanchayatService panchayatService =new PanchayatServiceImpl();
	private static VillageService villageService = new VillageServiceImpl();
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	Scanner ss = new Scanner(System.in);
	int choice = 0;
	do {
		System.out.println("\n1.Add Village\n2.Show all villages\n3.Exit");
		System.out.println("Enter choice");
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("enter the village name: ");
			String villageName = ss.nextLine();
			
			System.out.println("Enter the village population: ");
			Integer population = sc.nextInt();
			
			System.out.println("Enter the block id (" + blockService.getAllBlocks() + "): ");
			Integer blockId = sc.nextInt();
			
			System.out.println("Enter panchayat id:"+panchayatService.getPanchayatByBlockId(blockId ));
			Integer panchayatId = sc.nextInt();
			
			Panchayat cPanchayat = panchayatService.getPanchayatByPanchayatId(panchayatId);
			
			while(!panchayatService.panchayatMatchesBlock(cPanchayat, blockId)) {
				System.out.println("Selected Panchayat should match selected block!\nEnter panchayat id:"+panchayatService.getPanchayatByBlockId(blockId ));
				panchayatId = sc.nextInt();
				
				cPanchayat = panchayatService.getPanchayatByPanchayatId(panchayatId);
			}
			
			Village village = new Village();
			
			Block b = new Block();
			b.setBlockId(blockId );
			village.setBlock(b);
			
			village.setVillageName(villageName);
			village.setPopulation(population);
			
			Panchayat p = new Panchayat();
			p.setPanchayatId(panchayatId);
			village.setPanchayat(p);
			
			String addVillage = villageService.addVillage(village);
			System.out.println(addVillage);
			
			break;
		case 2:
			List<Village> villageList = villageService.getAllVillages();
			if(villageList.size() != 0) {
				villageList.forEach(cVillage -> System.out.println(cVillage));
			}
			else {
				System.out.println("There are no villages yet.");
			}
			break;
		case 3:
			System.out.println("\nProgram Exited Successfully. Bye Bye!");
			break;
		default:
			System.out.println("Enter a deafult value!");
			break;
		}
		
	} while (choice != 3);
}
}
