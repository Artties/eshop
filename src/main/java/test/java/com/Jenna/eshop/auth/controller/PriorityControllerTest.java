package test.java.com.Jenna.eshop.auth.controller;

import com.Jenna.eshop.auth.constant.PriorityType;
import com.Jenna.eshop.auth.controller.PriorityController;
import com.Jenna.eshop.auth.domain.PriorityDO;
import com.Jenna.eshop.auth.domain.PriorityDTO;
import com.Jenna.eshop.auth.domain.PriorityVO;
import com.Jenna.eshop.auth.service.impl.PriorityService;
import com.Jenna.eshop.common.util.DateProvider;
import com.alibaba.fastjson.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * 权限管理模块的controller组件的单元测试类
 * @author Jenna C He
 * @date 2023/04/18 10:06
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PriorityController.class)
public class PriorityControllerTest {
    /**
     * mvc测试模拟类
     */
    @Autowired
    private MockMvc mvc;
    /**
     * 权限管理模块的service组件
     */
    @MockBean
    private PriorityService priorityService;
    /**
     * 日期辅助组件
     */
    @MockBean
    DateProvider dateProvider;

    /**
     * 初始化方法
     */
    @Before
    public void setup() throws Exception {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = dateFormatter.parse(dateFormatter.format(new Date()));

        when(dateProvider.getCurrentTime()).thenReturn(currentTime);
    }


    /**
     * 测试查询根权限
     * @throws Exception
     */
    @Test
    public void testListRootPriorities() throws Exception {
        Long parentId = null;
        List<PriorityDTO> rootPriorityDTOs = createMockPriorityDTOs(parentId);
        when(priorityService.listRootPriorities()).thenReturn(rootPriorityDTOs);
        List<PriorityVO> rootPriorityVOs = convertPriorityDTOs2VOs(rootPriorityDTOs);

        mvc.perform(get("/auth/priority/root"))
                .andExpect(content().json(JSONArray.toJSONString(rootPriorityDTOs)));
    }


    /**
     * 构造模拟的权限DO集合
     * @param parentId 父权限id
     * @return 权限DO集合
     * @throws Exception
     */
    private List<PriorityDTO> createMockPriorityDTOs(Long parentId) throws Exception {
        Long id1 = 1L;
        Long id2 = 2L;

        List<PriorityDTO> rootPriorityDTOs = new ArrayList<PriorityDTO>();
        rootPriorityDTOs.add(createMockPriorityDTO(id1, parentId));
        rootPriorityDTOs.add(createMockPriorityDTO(id2, parentId));

        return rootPriorityDTOs;
    }


    /**
     * 构造一个权限DO对象
     * @return 权限DO对象
     * @throws Exception
     */
    private PriorityDTO createMockPriorityDTO(Long id, Long parentId) throws Exception {
        Random random = new Random();
        int randomInt = random.nextInt() * 100;

        PriorityDTO priorityDO = new PriorityDTO();
        priorityDO.setId(id);
        priorityDO.setCode("TEST_" + randomInt);
        priorityDO.setGmtCreate(dateProvider.getCurrentTime());
        priorityDO.setGmtModified(dateProvider.getCurrentTime());
        priorityDO.setParentId(parentId);
        priorityDO.setPriorityComment("TEST_" + randomInt);
        priorityDO.setPriorityType(PriorityType.MENU);
        priorityDO.setUrl("http://127.0.0.1/" + randomInt);

        return priorityDO;
    }


    /**
     * 将权限DO对象转换为权限DTO对象
     * @param priorityDTO 权限DO对象
     * @return 权限DTO对象
     */
    private PriorityVO convertPriorityDTO2VO(PriorityDTO priorityDTO) throws Exception {
        PriorityVO priorityVO = new PriorityVO();
        priorityVO.setCode(priorityDTO.getCode());
        priorityVO.setGmtCreate(priorityDTO.getGmtCreate());
        priorityVO.setGmtModified(priorityDTO.getGmtModified());
        priorityVO.setId(priorityDTO.getId());
        priorityVO.setParentId(priorityDTO.getParentId());
        priorityVO.setPriorityComment(priorityDTO.getPriorityComment());
        priorityVO.setPriorityType(priorityDTO.getPriorityType());
        priorityVO.setUrl(priorityDTO.getUrl());
        return priorityVO;
    }


    /**
     * 将权限的VO集合转换为权限的DTO集合
     * @param priorityDTOs 权限的DTO集合
     * @return 权限DTO集合
     */
    private List<PriorityVO> convertPriorityDTOs2VOs(
            List<PriorityDTO> priorityDTOs) throws Exception {
        List<PriorityVO> priorityVOs = new ArrayList<PriorityVO>(priorityDTOs.size());
        for(PriorityDTO priorityDTO : priorityDTOs){
            priorityVOs.add(convertPriorityDTO2VO(priorityDTO));
        }
        return priorityVOs;
    }

}
