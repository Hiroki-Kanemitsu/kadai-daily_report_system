package models.validators;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import models.Report;

public class ReportValidator {
    public static List<String> validate(Report r) {
        List<String> errors = new ArrayList<String>();

        String title_error = _validateTitle(r.getTitle());
        if(!title_error.equals("")) {
            errors.add(title_error);
        }

        String content_error = _validateContent(r.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }

        String started_at_error = _validateStarted_at(r.getStarted_at());
        if(!started_at_error.equals("")) {
            errors.add(started_at_error);
        }

        String finished_at_error = _validateFinished_at(r.getFinished_at());
        if(!finished_at_error.equals("")) {
            errors.add(finished_at_error);
        }

        String after_error = _validateAfter(r.getStarted_at(),r.getFinished_at());
        if(!after_error.equals("")) {
            errors.add(after_error);
        }

        return errors;
    }


    private static String _validateTitle(String title) {
        if(title == null || title.equals("")) {
            return "タイトルを入力してください。";
            }

        return "";
    }

    private static String _validateContent(String content) {
        if(content == null || content.equals("")) {
            return "内容を入力してください。";
            }

        return "";
    }

    private static String _validateStarted_at(Time started_at) {
        if(started_at == null || started_at.equals("")) {
            return "出勤時間を打刻してください。";
            }

        return "";
    }

    private static String _validateFinished_at(Time finished_at) {
        if(finished_at == null || finished_at.equals("")) {
            return "退勤時間を打刻してください。";
            }

        return "";
    }

    public static String _validateAfter(Time started_at, Time finished_at) {
        // もし出勤時間と退勤時間を比べて出勤時間が先ならば
        if(started_at.before(finished_at)) {
            return "";
        }else{
            return "出勤時刻と退勤時刻が逆に入力されています";
        }
    }

}
