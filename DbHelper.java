package btn.k23.dhcantho.db4odatabase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonlonglxag on 12/9/16.
 */

public class DbHelper {

    int score=0;
    int qid=0;
    Question currentQ;
    ObjectContainer db;

    public DbHelper(String dbPath) {
        //db = database;
        Log.e("String Data Main: ",dbPath);
        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), dbPath);
        //Insert an object:
        //creates object
        //Person p1  = new Person("Son", 100, "Database@db4o.com");
        //saves object
        /*
        try {
            db.store(p1 );
            addQuestions();
            //----Search all QBE----
            Person person = new Person();
            ObjectSet<Person> persons = db.queryByExample(person);
            for (Person ps: persons){
                Log.e("Test DbHelper: ", ps.toString() );
            }
        } finally {
            db.close();
        }
        */
        addQuestions();
    }

    public DbHelper(){
        addQuestions();
    }

    private void addQuestions() { //---- Chèn dữ liệu - Insert  Database

        Question q1=new Question(1,"The CPU is large chip …………… the computer",
                "","INSIDE","ONTO","OUE","FROM","INSIDE");
        db.store(q1);

        Question q2=new Question(2,"Data always flows …………. The CPU …………The address bus",
                "","FROM/TO","TO/TO","TO/FROM","ONTO/FROM","FROM/TO");
        db.store(q2);

        Question q3=new Question(3," Is Susan ........... home?",
                "","in","at","on","under","at");
        db.store(q3);

        Question q4=new Question(4,"Do the children go to school every day?",
                "","Yes, they go","Yes, they do","They go","No, they don't go","Yes, they do");
        db.store(q4);

        Question q5=new Question(5,"What ............ now?",
                "","is the time","does the time","is time","is it","is the time");
        db.store(q5);

        Question q6=new Question(6,"They always go to school ............. bicycle.",
                "","with","in","on","by","by");
        db.store(q6);

        Question q7=new Question(7,"What color ........... his new car?",
                "","have","is","does","are","is");
        db.store(q7);

        Question q8=new Question(8,"Are there many students in Room 12?",
                "","Yes there are.","Yes, they are.","Some are.","No they aren't.","Yes there are.");
        db.store(q8);
        Question q9=new Question(9,"You should do your ................. before going to class.",
                "","home work","homework","homeworks","housework","homework");
        db.store(q9);
        Question q10=new Question(10,"Are your free ............ Friday evening?",
                "","in","at","on","from","on");
        db.store(q10);
        Question q11=new Question(11,"There are six pencils ........... the box.",
                "","in","at","on","into","in");
        db.store(q11);
        Question q12=new Question(12,"I'm cleaning the floor. Can your help ............?",
                "","I","me","my","mind","me");
        db.store(q12);
        Question q13=new Question(13,"What are you doing? - ............. are planting some trees.",
                "","we","us","our","ours","us");
        db.store(q13);
        Question q14=new Question(14,"Mary is doing her homework and ........... brother is helping her.",
                "","she","hers","her","she's","her");
        db.store(q14);
        Question q15=new Question(15,"Jane's books are on the floor. Please, put ........... on the table.",
                "","they","them","their","theirs","them");
        db.store(q15);
        Question q16=new Question(16,"When's ............ birthday?",
                "","his","he","him","he's","his");
        db.store(q16);
        Question q17=new Question(17,"Whose bicycle is it? It's .............",
                "","he","her","hers","she","hers");
        db.store(q17);
        Question q18=new Question(18,"How old is .............?",
                "","she","her","hers","his","she");
        db.store(q18);
        Question q19=new Question(19,"There are .......... eggs on the table.",
                "","some","any","many","much","some");
        db.store(q19);
        Question q20=new Question(20,"Is there .......... cheese on the table?",
                "","some","any","many","much","any");
        db.store(q20);
        Question q21=new Question(21,"How .............. cakes does she want?",
                "","some","any","many","much","many");
        db.store(q21);
        Question q22=new Question(22,"There is ............ milk in the glass.",
                "","some","any","many","much","some");
        db.store(q22);
        Question q23=new Question(23,"How ............. meat do you want?",
                "","some","any","many","much","much");
        db.store(q23);
        Question q24=new Question(24,"There isn't .............. coffee in the cup.",
                "","some","any","many","much","any");
        db.store(q24);
        Question q25=new Question(25,"They want ............... coffee, but they don't want any bread.",
                "","some","any","many","much","some");
        db.store(q25);
        Question q26=new Question(26,"Is this your pencil? No, it isn't. It's .............. pencil.",
                "","my","her","our","hers","her");
        db.store(q26);
        Question q27=new Question(27,"................... parents are workers.",
                "","We","They","Our","I","Our");
        db.store(q27);
        Question q28=new Question(28,"Your sister is a student and his sister is a student, ................",
                "","both","also","and","too","too");
        db.store(q28);
        Question q29=new Question(29,"I am ........... teacher.",
                "","the","a","an","no article","a");
        db.store(q29);
        Question q30=new Question(30,"We are both ................... doctors.",
                "","the","a","an","no article","no article");
        db.store(q30);


        Log.e(" AddQuestions: ", "OK " );

    }

    public List<Question> getAllQuestions(){ //----add questions to list

        List<Question> quesList = new ArrayList<Question>();

        try{
            //----Search all QBE----
            Question question = new Question();
            ObjectSet<Question> questions = db.queryByExample(question);
            for (Question quest:questions){
                quesList.add(quest);
                Log.e("Quest value: ", quest.getANSWER());
            }
        }finally{
            db.close();
        }
        //Log.e("Test get all Questions: ", "OK " );
        return quesList;
    }

    public int rowcount(){ //-----Thuật toán tính điểm trắc nghiệm

        int row=0;

        return row;
    }
}
