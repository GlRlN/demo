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
## grade 추가 및 Setter 수동 추가
    private String name;
    private int grade;

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }


# StudentRequest
## Getter, Setter, 변수 grade 추가
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
