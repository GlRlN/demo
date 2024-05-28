# IndexController


    @GetMapping("/index2")
    public String doGet(Model model) {
        model.addAttribute("sr", new StudentRequest());
        return "index.html";
    }

    @PostMapping("/index2")
    public String doPost(Model model, @ModelAttribute("sr") StudentRequest sr) {
        studentService.saveStudent(sr);
        model.addAttribute("name", sr.name);
        return "output.html";
    }

# Student
## grade 추가 ~~및 Setter 수동 추가~~ 버그 고쳤으므로 Setter로 처리
    private String name;
    private int grade;

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }


# StudentRequest
## Getter, Setter, 변수 grade 추가 -> 얘네는 수동으로 잡아줘야 가능
    public int grade;
  
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }

# index.html 수정
## StudentRequest 받은 것을 th:object="${sr}" 로 추가 -> Request 이름 변경시 object 내용수정
## input의 name 대신 th:field="*{Request의 변수명}" 형태로 작성
    <form th:object="${sr}" method="post" action="index2">
        이름 <input th:field="*{name}">
        학년 <input th:field="*{grade}">
        <button>전달</button>
    </form>
