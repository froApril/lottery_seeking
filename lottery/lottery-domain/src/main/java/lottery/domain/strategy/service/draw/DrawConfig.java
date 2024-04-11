package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.annotation.StrategyMode;
import lottery.domain.strategy.repository.impl.StrategyRepository;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.springframework.core.annotation.AnnotationUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DrawConfig{

    @Resource
    private List<IDrawAlgorithm> algorithmList = new ArrayList<IDrawAlgorithm>();

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        algorithmList.forEach(algorithm -> {
            StrategyMode strategyMode = AnnotationUtils.findAnnotation(algorithm.getClass(), StrategyMode.class);
            if (strategyMode != null) {
                drawAlgorithmMap.put(strategyMode.strategyMode().getId(), algorithm);
            }
        });
    }


}
