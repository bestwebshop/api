package tech.bestwebshop.api.monitordashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
public class MonitorDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorDashboardApplication.class, args);
    }

}
