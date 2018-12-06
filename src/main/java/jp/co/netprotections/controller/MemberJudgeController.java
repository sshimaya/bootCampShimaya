package jp.co.netprotections.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.netprotections.dto.MemberJudgeRequestDto;
import jp.co.netprotections.dto.MemberJudgeRequestListDto;
import jp.co.netprotections.dto.MemberJudgeResponseDto;
import jp.co.netprotections.service.MemberJudgeService;

@RestController
public class MemberJudgeController {

	@RequestMapping(value="/main", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<MemberJudgeResponseDto> execute(@RequestBody MemberJudgeRequestListDto request) {

		// 結果のリストを初期化します
		List<MemberJudgeResponseDto> judgedCandidatesResultList = new ArrayList <MemberJudgeResponseDto> ();

		// 入力されたリストを取得します
		List<MemberJudgeRequestDto> memberCandidatesList = request.getMemberCandidatesList();

		//判定できる要素をリストに入れる
		List<MemberJudgeResponseDto> normalList = new ArrayList<>();

		//判定できない要素をリストに入れる
		List<MemberJudgeResponseDto> errorList = new ArrayList<>();


//		クライアントからリクエストを受け取ったときに、以下の2つの不正がある場合は処理を中断して空のレスポンスを返却してください。
//		①リクエストのリストには正常な隊員候補情報が一件以上セットされていること。
//			-②リストの中で、不正な値がはいっている、ないしはnullを含んでいる場合は、正常な隊員情報だけ判定して返却するようにする
//			-③リストに、一つも正常なリクエストが入ってない場合は空のリストを返却するようにする
//			-④複数オブジェクトのリストを受け取った場合、nullが含まれていればそのオブジェクトは名前をnullにしてfalseを設定する
//			-⑤名前のない隊員オブジェクトは、名前をnullに設定して、Falseとする。
//		⑥隊員情報の各属性は全て半角数値(int)であり、0以上5以下の値のみ受け付けるようにすること。

		//③リストが空なら空のレスポンス返す
		if (memberCandidatesList == null || memberCandidatesList.size() == 0) {
			return judgedCandidatesResultList;
		}

		//②中身はこの中で判定
		for (MemberJudgeRequestDto memberCandidates:memberCandidatesList) {
			//メソッドは切り出して書く
			//この書き方でtrue（=空か不正）の場合という条件を意味できている
			//処理としては⑤
			if (hasInvalidArgument(memberCandidates)) {
				MemberJudgeRequestDto req = new MemberJudgeRequestDto();
				MemberJudgeResponseDto res = new MemberJudgeResponseDto();

				//もし無効な値があったら、null/falseで返す
				res.setMemberName(null);
				res.setEnlistedPropriety(false);

				//無効な配列要素はエラーリストに入れる
				errorList.add(res);
			}
			//有効な配列要素は判定してノーマルリストに入れる
			MemberJudgeResponseDto response = new MemberJudgeResponseDto();
			MemberJudgeService service = new MemberJudgeService();
			response = service.service(memberCandidates);
			normalList.add(response);
		}
		//2種類を統合する
		judgedCandidatesResultList.addAll(errorList);
		judgedCandidatesResultList.addAll(normalList);

		return judgedCandidatesResultList;
	}
	//無効の判定はここで
	private boolean hasInvalidArgument(MemberJudgeRequestDto req) {
		if (req.getMemberName() == null) {
			return true;
		}

		if (req.getEventPlanning() > 5 || req.getEventPlanning() < 0) {
			return true;
		}

		if (req.getCogitation() > 5 || req.getCogitation() < 0) {
			return true;
		}

		if (req.getCoodination() > 5 || req.getCoodination() < 0) {
			return true;
		}

		if (req.getInfrastructureKnowledge() > 5 || req.getInfrastructureKnowledge() < 0) {
			return true;
		}

		if (req.getProgrammingAbility() > 5 || req.getProgrammingAbility() < 0) {
			return true;
		}

		return false;
	}


}


