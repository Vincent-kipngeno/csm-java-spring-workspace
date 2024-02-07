package tech.csm.controller;

import java.util.List;
import java.util.Scanner;

import tech.csm.domain.ProjectVO;
import tech.csm.domain.TechnologyVO;
import tech.csm.service.TechnologyService;
import tech.csm.service.TechnologyServiceImpl;
import tech.csm.service.ProjectService;
import tech.csm.service.ProjectServiceImpl;
import tech.csm.util.DBUtil;

public class ProjectController {

	private static TechnologyService technologyService=new TechnologyServiceImpl();
	private static ProjectService projectService=new ProjectServiceImpl();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int choice;		
		do {
			System.out.println("**************************************");
			System.out.println("*         Project Information        *");
			System.out.println("**************************************");
			System.out.println(
					"\n1.Update Project\n2.Insert Project\n" + "3.Display Projects\n4.Delete Project\n"
							+ "5.Exit\nEnter your Choice : ");
			choice = sc.nextInt();
			ProjectVO projectVO = null;
			switch (choice) {
			case 1:
				projectVO=updateProject();
				if (projectVO != null) {
					String msg=projectService.updateProject(projectVO);
					System.out.println(msg);
				}
				break;
			case 2:
				projectVO=inputProject();
				if (projectVO != null) {
					String msg=projectService.saveProject(projectVO);
					System.out.println(msg);
				}
				break;
			case 3:
				displayProjects();
				break;
			case 4:
				deleteProject();
				break;
			case 5:
				exitProgram();			
				break;
			default:
				System.out.println("invalid option!!");
			}

		} while (true);
		
	}

	private static ProjectVO inputProject() {
		Scanner ss = new Scanner(System.in);
		ProjectVO projectVO=new ProjectVO();
		
		System.out.println("Enter Project ID");
		String projectID = ss.nextLine();
		
		ProjectVO projectExists = projectService.getProjectById(projectID);

        while (projectExists != null) {
            System.out.println("Project with that ID already exists.");
            System.out.println("Enter Project ID");
    		projectID = ss.nextLine();
    		
    		projectExists = projectService.getProjectById(projectID);
        }
		projectVO.setProjectId(projectID);
		
		System.out.println("Enter Project Name");
		projectVO.setProjectName(ss.nextLine());

		System.out.println("Enter PM name");
		projectVO.setPmName(ss.nextLine());
		
		System.out.println("Enter Technology Name "+ technologyService.getAllTechnologies());
		TechnologyVO technologyVO = technologyService.getTechnologyByName(ss.nextLine());
		while (technologyVO == null) {
			System.out.println("Enter an existing Technology Name "+ technologyService.getAllTechnologies());
			technologyVO = technologyService.getTechnologyByName(ss.nextLine());
		}
		projectVO.setTechnology(technologyVO);
		
		System.out.print("Do you want to insert? (yes/no): ");
        String updateChoice = ss.nextLine();

        if ("yes".equalsIgnoreCase(updateChoice)) {
        	return projectVO;
        } else {
            System.out.println("Insert canceled.");
            clearScreen();
            return null;
        }
	}
	
	private static ProjectVO updateProject() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Project ID: ");
        String projectId = scanner.nextLine();

        ProjectVO projectVO = projectService.getProjectById(projectId);

        if (projectVO == null) {
            System.out.println("Invalid Project ID.");
            clearScreen();
            return projectVO;
        }

        System.out.println("-----------Project Details-------------");
        System.out.println("Project Name: " + projectVO.getProjectName());
        System.out.println("PM Name: " + projectVO.getPmName());
        System.out.println("Technology Name: " + projectVO.getTechnology().getTechnologyName());

        System.out.print("Enter New PM Name: ");
        String newPmName = scanner.nextLine();

        System.out.print("Do you want to update? (yes/no): ");
        String updateChoice = scanner.nextLine();

        if ("yes".equalsIgnoreCase(updateChoice)) {
            projectVO.setPmName(newPmName);
        } else {
            System.out.println("Update canceled.");
            clearScreen();
            return null;
        }
        
        return projectVO;
	}
	
	public static void displayProjects() {
        System.out.printf("%-15s%-25s%-20s%-20s%n", "Project ID", "Project Name", "PM Name", "Technology Name");
        System.out.println("---------------------------------------------------------------------------------");
        
        List<ProjectVO> projectVOList = projectService.getAllProjects();
        
        for (ProjectVO projectVO : projectVOList) {
            System.out.printf("%-15s%-25s%-20s%-20s%n",
                    projectVO.getProjectId(),
                    projectVO.getProjectName(),
                    projectVO.getPmName(),
                    projectVO.getTechnology().getTechnologyName());
        }

        System.out.println("\nPress Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearScreen();
    }
	
	private static void deleteProject() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter Project ID: ");
	    String projectId = scanner.nextLine();

	    ProjectVO projectVO = projectService.getProjectById(projectId);

	    if (projectVO == null) {
	        System.out.println("Invalid Project ID.");
	        clearScreen();
	        return;
	    }

	    System.out.println("-----------Project Details-------------");
	    System.out.println("Project Name: " + projectVO.getProjectName());
	    System.out.println("PM Name: " + projectVO.getPmName());
	    System.out.println("Technology Name: " + projectVO.getTechnology().getTechnologyName());

	    System.out.print("Do you want to delete? (yes/no): ");
	    String deleteChoice = scanner.nextLine();

	    if ("yes".equalsIgnoreCase(deleteChoice)) {
	        String result = projectService.deleteProjectById(projectId);
	        System.out.println(result);
	    } else {
	        System.out.println("Deletion canceled.");
	        clearScreen();
	    }
	}
	
	private static void exitProgram() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you really want to exit? (yes/no): ");
        String exitChoice = scanner.nextLine();

        if ("yes".equalsIgnoreCase(exitChoice)) {
            System.out.println("Exiting program. Goodbye!");
            DBUtil.closeConnection();
            System.exit(0);
        } else {
            clearScreen();
        }
    }
	
	private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
