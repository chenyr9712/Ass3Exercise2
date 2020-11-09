
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Font;

public class NumberView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_red;
	private JTextField textField_green;
	private JTextField textField_blue;
	private GraphView graphView;

	/**
	 * Create the frame.
	 */
	public NumberView() {
		setTitle("NumberView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Red");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 32, 40, 15);
		contentPane.add(lblNewLabel);

		textField_red = new JTextField();
		textField_red.setBounds(75, 28, 135, 20);
		contentPane.add(textField_red);
		textField_red.setColumns(10);

		JLabel lblGreen = new JLabel("Green");
		lblGreen.setFont(new Font("Consolas", Font.BOLD, 15));
		lblGreen.setBounds(25, 70, 40, 15);
		contentPane.add(lblGreen);

		textField_green = new JTextField();
		textField_green.setColumns(10);
		textField_green.setBounds(75, 66, 135, 20);
		contentPane.add(textField_green);

		JLabel lblBlue = new JLabel("Blue");
		lblBlue.setFont(new Font("Consolas", Font.BOLD, 15));
		lblBlue.setBounds(25, 108, 40, 15);
		contentPane.add(lblBlue);

		textField_blue = new JTextField();
		textField_blue.setColumns(10);
		textField_blue.setBounds(75, 104, 135, 20);
		contentPane.add(textField_blue);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(75, 150, 93, 23);
		contentPane.add(btnNewButton); 

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int red = Integer.parseInt(textField_red.getText().trim());
					int blue = Integer.parseInt(textField_blue.getText().trim());
					int green = Integer.parseInt(textField_green.getText().trim());
					Model model = new Model(red, green, blue);
					graphView.update(model);
				} catch (Exception ex) {

				}
			}
		});
		 
		graphView = new GraphView();
		graphView.setVisible(true);
	}
}
