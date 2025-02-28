package com.example.lectureconsumer.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KafkaHealthIndicator extends AbstractHealthIndicator {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient client = AdminClient.create(props)) {
            client.describeCluster().nodes().get();
            builder.up();
        } catch (Exception e) {
            builder.down().withDetail("error", e.getMessage());
        }
    }
}
