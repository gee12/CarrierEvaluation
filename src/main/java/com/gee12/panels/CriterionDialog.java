package com.gee12.panels;

import static com.gee12.panels.CooperatePanel.dataFieldComparator;
import com.gee12.tableModels.DataTableModel;
import com.gee12.structures.Project;
import com.gee12.structures.Criterion;
import com.gee12.structures.DataField;
import com.gee12.structures.Project.Stages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JScrollPane;

/**
 *
 * @author Иван
 */
public class CriterionDialog extends MyodalDialog {
    
    public enum ActionType {
        Add,
        Edit,
        Delete
    }
    
    public static final int NAME_CELL_WIDTH = 570;
    public static final int VALUE_CELL_WIDTH = 150;
    public static final int TYPE_CELL_WIDTH = 80;
    
    private final DataTableModel dataTM;
    private Project curProject = null;
    private Criterion curCriterion = null;
    private final MyButtonGroup actionTypeGroup;
    private final MyButtonGroup critTypeGroup;
    private Stages curStage = Stages.STAGE1_CHOISE;
    private ActionType actionType = ActionType.Add;
    
    public CriterionDialog(Project proj, Criterion crit, Stages stage) {
        dataTM = new DataTableModel();
        actionTypeGroup = new MyButtonGroup();
        critTypeGroup = new MyButtonGroup();
	//
	actionTypeGroup.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
                selectActionType(e.getActionCommand());
	    }
	});        
        
        initComponents();
        initDialogComponents();
        
        dataTable.getColumnModel().getColumn(0).setPreferredWidth(NAME_CELL_WIDTH);
        dataTable.getColumnModel().getColumn(1).setPreferredWidth(VALUE_CELL_WIDTH);
        dataTable.getColumnModel().getColumn(2).setPreferredWidth(TYPE_CELL_WIDTH);
        
        curProject = proj;
        curStage = stage;
        curCriterion = crit;
        initTable(stage, proj);
        
        String actionCommand = "";
        if (crit == null) {
            curCriterion = Criterion.EMPTY;
            actionCommand = addRadioButton.getActionCommand();
            addRadioButton.setSelected(true);
            editRadioButton.setEnabled(false);
            deleteRadioButton.setEnabled(false);
        } else {
            actionCommand = editRadioButton.getActionCommand();
        }
        selectActionType(actionCommand);
    }
    
    private void selectActionType(String actionCommand) {
        if (actionCommand.equalsIgnoreCase(addRadioButton.getActionCommand())) {
            actionType = ActionType.Add;
            initFields(Criterion.EMPTY);
        } else if (actionCommand.equalsIgnoreCase(editRadioButton.getActionCommand())) {
            actionType = ActionType.Edit;
            initFields(curCriterion);
        } else if (actionCommand.equalsIgnoreCase(deleteRadioButton.getActionCommand())) {
            actionType = ActionType.Delete;
            initFields(curCriterion);
        }
    }
    
    public void initFields(Criterion crit) {
        nameTextField.setText(crit.getName());
        formulaTextField.setText(crit.getFormula());
        valueTextField.setText(crit.getValue());
    }
    
    
    public void initTable(Stages stage, Project proj) {
        List <DataField> dataFields = proj.getStage(stage).getDataFields();
        // for rows sort
        dataFields.sort(dataFieldComparator);
        dataTM.setData(dataFields);
    }
    
    public Criterion getCriterion() {
        return curCriterion;
    }
    
    public ActionType getActionType() {
        return actionType;
    }
    
    public void pasteStringIntoFormulaTextField(String value) {
        int caretPos = formulaTextField.getCaretPosition();
        String res =  new StringBuffer(formulaTextField.getText()).insert(caretPos, value).toString();
        formulaTextField.setText(res);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        formulaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();
        otherRadioButton = new javax.swing.JRadioButton();
        baseRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addRadioButton = new javax.swing.JRadioButton();
        editRadioButton = new javax.swing.JRadioButton();
        deleteRadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        baseDataScrollPane = new javax.swing.JScrollPane(dataTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        dataTable = new javax.swing.JTable();

        setTitle("Критерий");

        cancelButton.setText("Отмена");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Готово");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Параметры"));

        formulaTextField.setAutoscrolls(false);

        jLabel3.setText("Имя");

        nameTextField.setAutoscrolls(false);

        jLabel4.setText("Формула");

        jLabel5.setText("Значение");

        valueTextField.setEnabled(false);

        critTypeGroup.add(otherRadioButton);
        otherRadioButton.setText("Дополнительный");

        critTypeGroup.add(baseRadioButton);
        baseRadioButton.setSelected(true);
        baseRadioButton.setText("Основной");

        jLabel7.setText("Тип");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField)
                    .addComponent(formulaTextField)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(baseRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(otherRadioButton))
                            .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(formulaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(baseRadioButton)
                    .addComponent(otherRadioButton))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Тип действия"));

        actionTypeGroup.add(addRadioButton);
        addRadioButton.setText("Создать новый");
        addRadioButton.setActionCommand("Создать новый");

        actionTypeGroup.add(editRadioButton);
        editRadioButton.setSelected(true);
        editRadioButton.setText("Редактировать");
        editRadioButton.setActionCommand("Редактировать");

        actionTypeGroup.add(deleteRadioButton);
        deleteRadioButton.setText("Удалить");
        deleteRadioButton.setActionCommand("Удалить");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addRadioButton)
                    .addComponent(editRadioButton)
                    .addComponent(deleteRadioButton)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(addRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Для добавления в формулу ссылки на ячейку данных кникните по ячейке в таблице");

        dataTable.setModel(dataTM);
        dataTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        dataTable.setName("Основные критерии"); // NOI18N
        dataTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        baseDataScrollPane.setViewportView(dataTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(baseDataScrollPane)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baseDataScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        result = false;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String name = nameTextField.getText();
        String formula = formulaTextField.getText();
        
        if (name.isEmpty() && formula.isEmpty())
            return;
        
        curCriterion.setName(name);
        curCriterion.setFormula(formula);
        
        result = true;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked
        int selectedRow = dataTable.getSelectedRow();
        DataField dataField = curProject.getStage(curStage).getDataFields()
                .get(dataTable.convertRowIndexToModel(selectedRow));
        pasteStringIntoFormulaTextField(dataField.getValueCellReference());
    }//GEN-LAST:event_dataTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addRadioButton;
    private javax.swing.JScrollPane baseDataScrollPane;
    private javax.swing.JRadioButton baseRadioButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JRadioButton deleteRadioButton;
    private javax.swing.JRadioButton editRadioButton;
    private javax.swing.JTextField formulaTextField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton otherRadioButton;
    private javax.swing.JTextField valueTextField;
    // End of variables declaration//GEN-END:variables
}
