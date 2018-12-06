package jp.co.netprotections.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;

@RunWith(JUnit4.class)
@SpringBootTest
public class MemberJudgeServiceTest {
	@Test
	//テストの際は戻り値定義しなくていい
	public void serviceTest1() {
		MemberJudgeService response = new MemberJudgeService();
		MemberJudgeRequestDto request = new MemberJudgeRequestDto();

		request.setMemberName("Hama");
		request.setEventPlanning(2);
		request.setCogitation(2);
		request.setCoodination(2);
		request.setProgrammingAbility(2);
		request.setInfrastructureKnowledge(4);

    	  //期待する値の設定
        String expectedName = "Hama";
        boolean expectedPropriety = true;

        //実際の値（テスト先のメソッド通した値）の設定
        //インスタンスとメソッドは同クラスで定義したものでないといけない
        MemberJudgeResponseDto actualResponse = response.service(request);
        String actualName = actualResponse.getMemberName();
        boolean actualPropriety = actualResponse.getEnlistedPropriety();

        //期待する値と実際の値の比較
        assertEquals(expectedName, actualName);
        assertEquals(expectedPropriety, actualPropriety);

	}

//		int totalScore = totalScore(request.getEventPlanning(), request.getCogitation(), request.getCoodination(), request.getProgrammingAbility(), request.getInfrastructureKnowledge());
//
//		if (request.getEventPlanning() <= 1 || request.getCoodination() <= 1 || totalScore <= 10) {
//			response.setMemberName(request.getMemberName());
//			response.setEnlistedPropriety(false);
//		} else {
//			response.setMemberName(request.getMemberName());
//			response.setEnlistedPropriety(true);
//		}
//
//		return response;
//	}
//
//	public int totalScore (int a, int b, int c, int d, int e) {
//		return a + b + c + d + e;
//	}

}
