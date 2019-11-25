package com.suntek.demo.config.apolloconfig;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ApiModel("url配置")
public class ConfigEntity {

    @Value("${hive.demo.comprehensive-display.url:}")
    @ApiModelProperty("综合展示")
    private String comprehensiveDisplay;

    @Value("${hive.demo.key-person.url:}")
    @ApiModelProperty("重点人员管控")
    private String keyPerson;

    @Value("${hive.demo.command-dispatch.url:}")
    @ApiModelProperty("指挥调度应用")
    private String commandDispatch;

    @Value("${hive.feishi.url:}")
    @ApiModelProperty("飞识人像识别系统")
    private String feishi;

    @Value("${hive.guangzhou.tollgate-data.url:}")
    @ApiModelProperty("广州卡口数据平台")
    private String tollgateData;

    @Value("${hive.data-analysis.url:}")
    @ApiModelProperty("智能终端取证数据分析系统")
    private String dataAnalysis;

    @Value("${hive.guangzhou.information-resource-service.url:}")
    @ApiModelProperty("广州公安信息资源服务平台")
    private String informationResource;

    @Value("${hive.guangdong.vehicle-application-system.url:}")
    @ApiModelProperty("广东省公安涉车综合应用系统")
    private String vehicleApplication;

    @Value("${hive.guangzhou.police-practical-platform.url:}")
    @ApiModelProperty("广州公安警务实战平台")
    private String policePractical;

    @Value("${hive.tourism-security-management.url:}")
    @ApiModelProperty("旅业治安管理系统")
    private String tourismSecurity;

    @Value("${hive.country.traffic-information.url:}")
    @ApiModelProperty("全国公安交通管理信息综合查询系统")
    private String trafficInformation;

    @Value("${hive.guangzhou.pgis.url:}")
    @ApiModelProperty("广州市警用地理信息系统")
    private String pgis;

    @Value("${hive.guangzhou.sis.url:}")
    @ApiModelProperty("广东广州SIS情报分析系统")
    private String sis;

    @Value("${hive.demo.application.url:}")
    @ApiModelProperty("应用中心")
    private String application;
}
