package com.redpois0n;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.security.Key;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class PanelReverser extends JPanel {
	
	private JTextField txtFile;
	private JTable table;
	private JTextField txtKey;
	private JTextField txtConfigEn;
	private JTextField txtConfig;

	public DefaultTableModel getModel() {
		return (DefaultTableModel)table.getModel();
	}

	public PanelReverser() {
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Reverse .jar Server (Not dropper)"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Content"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Info"));
		
		JButton btnReverseAndDisplay = new JButton("Reverse and display info");
		btnReverseAndDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				load(txtFile.getText());
			}
		});
		btnReverseAndDisplay.setIcon(new ImageIcon(PanelReverser.class.getResource("/icons/drill--arrow.png")));
		
		JButton btnExportServerFrom = new JButton("Export server from dropper");
		btnExportServerFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				c.showOpenDialog(null);
				File file = c.getSelectedFile();
				
				if (file != null) {
					extract(file);
				}
			}
		});
		btnExportServerFrom.setIcon(new ImageIcon(PanelReverser.class.getResource("/icons/drill--pencil.png")));
		
		JLabel lblHttpredpoisncom = new JLabel("http://redpois0n.com");
		lblHttpredpoisncom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("http://redpois0n.com"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblHttpredpoisncom.setForeground(Color.BLUE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHttpredpoisncom)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExportServerFrom)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReverseAndDisplay)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReverseAndDisplay)
						.addComponent(btnExportServerFrom)
						.addComponent(lblHttpredpoisncom))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel lblKey = new JLabel("Key:");
		
		txtKey = new JTextField();
		txtKey.setColumns(10);
		
		JLabel lblConfigencrypted = new JLabel("Config: (Encrypted)");
		
		txtConfigEn = new JTextField();
		txtConfigEn.setColumns(10);
		
		JLabel lblConfigdecrypted = new JLabel("Config: (Decrypted)");
		
		txtConfig = new JTextField();
		txtConfig.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblKey)
							.addGap(18)
							.addComponent(txtKey, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
						.addComponent(lblConfigencrypted)
						.addComponent(txtConfigEn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfigdecrypted)
						.addComponent(txtConfig, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKey)
						.addComponent(txtKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblConfigencrypted)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtConfigEn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblConfigdecrypted)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtConfig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Key", "Value"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(167);
		table.getColumnModel().getColumn(1).setPreferredWidth(163);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(20);
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblFile = new JLabel("File");
		
		txtFile = new JTextField();
		txtFile.setEditable(false);
		txtFile.setColumns(10);
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
				c.showOpenDialog(null);
				File file = c.getSelectedFile();
				
				if (file != null) {
					txtFile.setText(file.getAbsolutePath());
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFile)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFile, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblFile)
							.addComponent(txtFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	
	public void load(String file) {
		load(new File(file));
	}
	
	public void load(File file) {
		try {
			ZipFile zip = new ZipFile(file);
			
			ZipEntry entryKey = null;
			ZipEntry entryConfig = null;
			
			Enumeration<? extends ZipEntry> entries = zip.entries();
			
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				if (entry.getName().equals("key.dat")) {
					entryKey = entry;
				} else if (entry.getName().equals("config.dat")) {
					entryConfig = entry;
				}
			}
			
			InputStream keyFileInputStream = zip.getInputStream(entryKey);
			
			byte[] key = new byte[keyFileInputStream.available()];
		    keyFileInputStream.read(key);
			
		    InputStream configFileInputStream = zip.getInputStream(entryConfig);
			
			byte[] config = new byte[configFileInputStream.available()];
			configFileInputStream.read(key);

			config = StringCrypter.decrypt(config, key);
			
			String sConfig = new String(config);
			
			txtConfig.setText(sConfig);
			
			String[] kv = sConfig.split("SPLIT");
			
			for (String str : kv) {
				String[] split = str.split("=");
				String k = split[0].trim();
				String v = split[1].trim();
				getModel().addRow(new Object[] { k, v });
			}
			
			zip.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Failed to load:\n\n" + ex.getClass().getSimpleName() + ": " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
	
	public void extract(File file) {
		try {
			ZipFile zip = new ZipFile(file);
			
			ZipEntry entryKey = null;
			ZipEntry entryDat = null;
			
			Enumeration<? extends ZipEntry> entries = zip.entries();
			
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				if (entry.getName().equals("key.dat")) {
					entryKey = entry;
				} else if (entry.getName().equals("enc.dat")) {
					entryDat = entry;
				}
			}
			
			InputStream keyInputStream = zip.getInputStream(entryKey);
			
			byte[] key = new byte[16];
			
			for (int i = 0; i < key.length; i++) {
				key[i] = (byte) keyInputStream.read();
			}
						
			InputStream in = zip.getInputStream(entryDat);
			OutputStream out = new FileOutputStream(new File(file.getParent(), "Decrypted Dropper.jar"));
			Cipher dcipher = Cipher.getInstance("AES");

			byte[] buffer = new byte[1024];
			
			Key sks = new SecretKeySpec(key, "AES");
			dcipher.init(Cipher.DECRYPT_MODE, sks);
			in = new CipherInputStream(in, dcipher);
			int numRead = 0;
			while ((numRead = in.read(buffer)) >= 0) {
				out.write(buffer, 0, numRead);
			}
			in.close();
			out.close();

			zip.close();
			
			JOptionPane.showMessageDialog(null, "Decrypted the server from dropper to\n" + new File(file.getParent(), "Decrypted Server.jar").getAbsolutePath(), "Reverser", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Failed to decrypt server from dropper:\n\n" + ex.getClass().getSimpleName() + ": " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}
}
