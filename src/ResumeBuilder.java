import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ResumeBuilder extends JFrame implements ActionListener {

	
	private JTextField nameField,emailField;
	private JTextArea educationArea,experienceArea,skillsArea,summaryArea;
	private JButton generateButton;
	
	public ResumeBuilder() {
		setTitle("Resume Builder");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel inputPanel=new JPanel();
		inputPanel.setLayout(new GridLayout(6,2,10,10));
		
		inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Summary:"));
        summaryArea = new JTextArea();
        inputPanel.add(summaryArea);

        inputPanel.add(new JLabel("Education:"));
        educationArea = new JTextArea();
        inputPanel.add(educationArea);

        inputPanel.add(new JLabel("Experience:"));
        experienceArea = new JTextArea();
        inputPanel.add(experienceArea);

        inputPanel.add(new JLabel("Skills:"));
        skillsArea = new JTextArea();
        inputPanel.add(skillsArea);

		
		JPanel buttonPanel = new JPanel();
		generateButton=new JButton("Generate");
		generateButton.addActionListener(this);
		buttonPanel.add(generateButton);
		
		mainPanel.add(inputPanel,BorderLayout.CENTER);
		mainPanel.add(buttonPanel,BorderLayout.SOUTH);
		
		add(mainPanel);
		setVisible(true);		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
           if(e.getSource() == generateButton) {
        	   String name = nameField.getText();
               String email = emailField.getText();
               String summary = summaryArea.getText();
               String education = educationArea.getText();
               String experience = experienceArea.getText();
               String skills = skillsArea.getText();

               generateResume(name, email, summary, education, experience, skills);
           }
	}
    
	public void generateResume(String name, String email, String summary, String education, String experience, String skills) {
		StringBuilder resume=new StringBuilder();
		resume.append("Name: ").append(name).append("\n");
		resume.append("Email: ").append(email).append("\n");
		resume.append("Summary: ").append(summary).append("\n");
		resume.append("Education: ").append(education).append("\n");
		resume.append("Experience: ").append(experience).append("\n");
		resume.append("Skills: ").append(skills).append("\n");
		
		JOptionPane.showMessageDialog(this,resume.toString(),"Generated Resume",JOptionPane.INFORMATION_MESSAGE);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ResumeBuilder();
			}
		});

	}


}
