package com.example.firstproject.clever.code;

import com.example.firstproject.clever.code.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FirstProject {

    @GetMapping("/allStudent")
    public ResponseEntity<?> getAllStudent(){
        Student student = new Student(1,"Alp",18,"Web Developer");
        Student student1 = new Student(2,"Humo",21,"Android Developer");
        Student student2 = new Student(3,"John",15,".NET Developer");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/oneStudent/{id}")
    public ResponseEntity<?> getOneStudent(@PathVariable int id){
        Student student = new Student(1,"Alp",18,"Web Developer");
        Student student1 = new Student(2,"Humo",21,"Android Developer");
        Student student2 = new Student(3,"John",15,".NET Developer");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        for (Student student3 : studentList) {
            if (student3.getId()==id){
                Student student4 = studentList.get(id-1);
                ResponseEntity<Student> ok = ResponseEntity.ok(student4);
                return ok;
            }
        }
        return ResponseEntity.ok("Topilmadi");
    }

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student dto){
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setCourse(dto.getCourse());

        List<Student> newStudentList = new ArrayList<>();
        newStudentList.add(student);
        return ResponseEntity.ok(newStudentList);
    }


    @PutMapping("/editStudent/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student editStudent,@PathVariable int id){
        Student student = new Student(1,"Alp",18,"Web Developer");
        if (student.getId()==id){
            student.setName(editStudent.getName());
            student.setCourse(editStudent.getCourse());
        }else {
            return ResponseEntity.ok("Not Found");
        }
        return ResponseEntity.ok(student);
    }



    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        Student student = new Student(1,"Alp",18,"Web Developer");
        Student student1 = new Student(2,"Humo",21,"Android Developer");
        Student student2 = new Student(3,"John",15,".NET Developer");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        for (Student student3 : studentList) {
            if (student3.getId()==id){
                studentList.remove(id - 1);
                ResponseEntity<String> ok = ResponseEntity.ok(id+"lik student o'chirildi!  |" + studentList.size());
                return ok;
            }
        }
        return ResponseEntity.ok("Topilmadi");
    }

}
