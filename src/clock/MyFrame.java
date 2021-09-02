package clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	//Calendar calender;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
    String day;
    String date;

	MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Clock Program");
		setLayout(new FlowLayout());
		setSize(350, 200);
		setResizable(false);

		timeFormat = new SimpleDateFormat("HH:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

		
		timeLabel = new JLabel();
		timeLabel.setFont( new Font("Ink Free", Font.BOLD,50));
		timeLabel.setForeground(new Color(0xedcb5d));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayLabel=new JLabel();
		dayLabel.setFont( new Font("Ink Free", Font.BOLD,32));

		dateLabel=new JLabel();
		dateLabel.setFont( new Font("Ink Free", Font.BOLD,32));

		add(timeLabel);
		add(dayLabel);
		add(dateLabel);
		
		setVisible(true);

		setTime();

	}

	public void setTime() {
		while (true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);

			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);

			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
