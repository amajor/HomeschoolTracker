package homeschooltracker;

public class App {
    public static void main(String[] args) {
        Lesson lesson = new Lesson(
                "Grade 1, Phonics & Reading, Lesson 12",
                "This is lesson 12 for phonics and reading.",
                false
        );

        lesson.addMaterial("Handbook for Reading, pages 20-25", false);
        lesson.addMaterial("Phonics workbook, page 30", false);

        lesson.printLessonName();
        lesson.printMaterialList();
    }
}
