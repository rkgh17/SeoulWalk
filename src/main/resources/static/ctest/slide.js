// 슬라이드 전체 크기(width)
const slide = document.querySelector(".slide");
let slideWidth = slide.clientWidth;

// 슬라이드 아이템
const slideItems = document.querySelectorAll(".slide_item");

// 넘기지 않게 하기 위한 변수
const maxSlide = slideItems.length;

// 버튼 엘리먼트 선택하기
const nextBtn = document.querySelector(".slide_next_button");

// 버튼 클릭할 때마다 바뀌는 슬라이드 위치 변수
let currSlide = 1;

// 다음 버튼 엘리먼트에 클릭 이벤트 추가
nextBtn.addEventListener("click",()=>{
	
	// 이후 버튼 누를 경우 현재 슬라이드 변경
	currSlide++;
	
	if(currSlide<= maxSlide){
		// 슬라이드 이동시키기 위한 offset 계산
		const offset = slideWidth * (currSlide - 1);
		
		// 각 슬라이드 아이템의 left에 offset 적용
		slideItems.forEach((i) => {
			i.setAttribute("style", `left: ${-offset}px`);
		});
	}
});

window.addEventListener("resize",()=>{
	slideWidth = slide.clientWidth;
});