package jp.co.netprotections.controller;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;

@RunWith(JUnit4.class)
@SpringBootTest
public class hasInvalidArgumentTest {

//	@Test
	public void hasInvalidArgument () {
		MemberJudgeResponseDto res = new MemberJudgeResponseDto();
		MemberJudgeRequestDto req = new MemberJudgeRequestDto();

		req.setMemberName(null);
		req.setCogitation(2);
		req.setCoodination(9);
		req.setEventPlanning(2);
		req.setInfrastructureKnowledge(2);
		req.setProgrammingAbility(2);

		String expectedResultName = "null";
		boolean expectedEnlistedProproety = false;
		String resultName = "a";
		boolean enlistedPropriety = true;

		if (req.getMemberName() == null) {
			resultName = "null" ;
		}

		if(req.getEventPlanning() < 0 || req.getEventPlanning() > 5) {
			enlistedPropriety = false;
		}

		if(req.getCoodination() < 0 || req.getCoodination() > 5) {
			enlistedPropriety = false;
		}

		if(req.getCogitation() < 0 || req.getCogitation() > 5) {
			enlistedPropriety = false;
		}

		if(req.getInfrastructureKnowledge() < 0 || req.getInfrastructureKnowledge() > 5) {
			enlistedPropriety = false;
		}

		if(req.getProgrammingAbility() < 0 || req.getProgrammingAbility() > 5) {
			enlistedPropriety = false;
		}

        assertEquals(expectedResultName, resultName);
        assertEquals(expectedEnlistedProproety, enlistedPropriety);


	}
}