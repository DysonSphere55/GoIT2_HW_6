import goit.database.Database;
import goit.database.DatabaseQueryService;
import goit.pojo.*;

import java.sql.Connection;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Connection connection = Database.getConnection();

        DatabaseQueryService dbQueryService = new DatabaseQueryService(connection);

        List<LongestProject> longestProjectList = dbQueryService.findLongestProject();
        longestProjectList.forEach(System.out::println);

        List<MaxSalaryWorker> maxSalaryWorkerList = dbQueryService.findMaxSalaryWorker();
        maxSalaryWorkerList.forEach(System.out::println);

        List<MaxProjectsClient> maxProjectsClientList = dbQueryService.findMaxProjectsClient();
        maxProjectsClientList.forEach(System.out::println);

        List<EldestWorker> eldestWorkerList = dbQueryService.findEldestWorker();
        eldestWorkerList.forEach(System.out::println);

        List<YoungestWorker> youngestWorkerList = dbQueryService.findYoungestWorker();
        youngestWorkerList.forEach(System.out::println);

        List<ProjectPrice> projectPriceList = dbQueryService.getProjectPrices();
        projectPriceList.forEach(System.out::println);
    }
}
