package haibao.com.api.data.response.school;

import java.io.Serializable;
import java.util.List;

/**
 * 练习数据模型
 * Created by Android on 2016-05-13.
 */
public class Exercise implements Serializable {

    private List<Dialogues> dialogues;
    private List<Image> image;
    private List<Images> images;
    private List<Repeat> repeat;
    private int practice_id;
    private int practice_type;
    private String practice_name;

    public class Dialogues implements Serializable {
        private List<Option> options;
        private int dialogue_id;
        private String cover;
        private String f30;
        private String vid;

        public class Option implements Serializable {
            private double trigger_second;
            private String audio;
            private String sentence;

            public double getTrigger_second() {
                return trigger_second;
            }

            public void setTrigger_second(double trigger_second) {
                this.trigger_second = trigger_second;
            }

            public String getAudio() {
                return audio;
            }

            public void setAudio(String audio) {
                this.audio = audio;
            }

            public String getSentence() {
                return sentence;
            }

            public void setSentence(String sentence) {
                this.sentence = sentence;
            }
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        public int getDialogue_id() {
            return dialogue_id;
        }

        public void setDialogue_id(int dialogue_id) {
            this.dialogue_id = dialogue_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getF30() {
            return f30;
        }

        public void setF30(String f30) {
            this.f30 = f30;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }
    }

    public class Repeat implements Serializable {
        private String audio;
        private String cover;
        private String sentence;

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getSentence() {
            return sentence;
        }

        public void setSentence(String sentence) {
            this.sentence = sentence;
        }
    }

    public class Image implements Serializable {
        private List<Option> options;
        private int ic_id;
        private String image;
        private String right_audio;
        private String wrong_audio;

        public class Option implements Serializable {
            private List<List<String>> coordinate_path;
            private String answer;
            private String answer_audio;
            private String question;
            private String question_audio;

            public List<List<String>> getCoordinate_path() {
                return coordinate_path;
            }

            public void setCoordinate_path(List<List<String>> coordinate_path) {
                this.coordinate_path = coordinate_path;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public String getAnswer_audio() {
                return answer_audio;
            }

            public void setAnswer_audio(String answer_audio) {
                this.answer_audio = answer_audio;
            }

            public String getQuestion() {
                return question;
            }

            public void setQuestion(String question) {
                this.question = question;
            }

            public String getQuestion_audio() {
                return question_audio;
            }

            public void setQuestion_audio(String question_audio) {
                this.question_audio = question_audio;
            }
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        public int getIc_id() {
            return ic_id;
        }

        public void setIc_id(int ic_id) {
            this.ic_id = ic_id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getRight_audio() {
            return right_audio;
        }

        public void setRight_audio(String right_audio) {
            this.right_audio = right_audio;
        }

        public String getWrong_audio() {
            return wrong_audio;
        }

        public void setWrong_audio(String wrong_audio) {
            this.wrong_audio = wrong_audio;
        }
    }

    public class Images implements Serializable {

        private List<Option> options;
        private int isc_id;
        private int right_options;
        private String question;
        private String question_audio;
        private String right_audio;
        private String wrong_audio;

        public class Option implements Serializable {
            private int is_right;
            private String audio;
            private String image;
            private String sentence;

            public int getIs_right() {
                return is_right;
            }

            public void setIs_right(int is_right) {
                this.is_right = is_right;
            }

            public String getAudio() {
                return audio;
            }

            public void setAudio(String audio) {
                this.audio = audio;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getSentence() {
                return sentence;
            }

            public void setSentence(String sentence) {
                this.sentence = sentence;
            }
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        public int getIsc_id() {
            return isc_id;
        }

        public void setIsc_id(int isc_id) {
            this.isc_id = isc_id;
        }

        public int getRight_options() {
            return right_options;
        }

        public void setRight_options(int right_options) {
            this.right_options = right_options;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getQuestion_audio() {
            return question_audio;
        }

        public void setQuestion_audio(String question_audio) {
            this.question_audio = question_audio;
        }

        public String getRight_audio() {
            return right_audio;
        }

        public void setRight_audio(String right_audio) {
            this.right_audio = right_audio;
        }

        public String getWrong_audio() {
            return wrong_audio;
        }

        public void setWrong_audio(String wrong_audio) {
            this.wrong_audio = wrong_audio;
        }
    }

    public List<Dialogues> getDialogues() {
        return dialogues;
    }

    public void setDialogues(List<Dialogues> dialogues) {
        this.dialogues = dialogues;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public int getPractice_id() {
        return practice_id;
    }

    public void setPractice_id(int practice_id) {
        this.practice_id = practice_id;
    }

    public int getPractice_type() {
        return practice_type;
    }

    public void setPractice_type(int practice_type) {
        this.practice_type = practice_type;
    }

    public List<Repeat> getRepeat() {
        return repeat;
    }

    public void setRepeat(List<Repeat> repeat) {
        this.repeat = repeat;
    }

    public String getPractice_name() {
        return practice_name;
    }

    public void setPractice_name(String practice_name) {
        this.practice_name = practice_name;
    }
}
