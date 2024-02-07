package tech.csm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.csm.entity.Block;
import tech.csm.entity.Village;
import tech.csm.service.BlockService;
import tech.csm.service.BlockServiceImpl;
import tech.csm.service.VillageService;
import tech.csm.service.VillageServiceImpl;

public class BlockFilter extends HttpServlet {
	
	private BlockService blockService;
	private VillageService villageService;
	
	public BlockFilter() {
		blockService=new BlockServiceImpl();
		villageService=new VillageServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pop = req.getParameter("vPop");
		String bId = req.getParameter("blockId");
		
		List<Block> blockList=blockService.getAllBlocks();
		List<Village> villageList;
		
		if(!pop.isBlank() && !bId.equals("0")) {
			villageList=villageService.getAllVillagesByBlockAndPopulation(Integer.parseInt(bId), Integer.parseInt(pop));
		}
		else if (!pop.isBlank()) {
			villageList=villageService.getAllVillagesByPopulation(Integer.parseInt(pop));
		}
		else if (!bId.equals("0")) {
			villageList=villageService.getAllVillagesByBlock(Integer.parseInt(bId));
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/getRegdForm");
			rd.forward(req, resp);
			return;
		}
		
		req.setAttribute("villageList", villageList);
		req.setAttribute("blockList", blockList);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("villageRegdForm.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
