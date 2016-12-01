package ui;

import appModel.AppModelControlGastos;
import model.Gasto;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.TableBuilder;
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class ControlDeGastosWindow extends Window<AppModelControlGastos> {
  public ControlDeGastosWindow(final WindowOwner owner, final AppModelControlGastos model) {
    super(owner, model);
  }
  
  public void createContents(final Panel mainPanel) {
    Panel _panel = new Panel(mainPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        ControlDeGastosWindow.this.setTitle("Control de gastos");
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        Panel _panel = new Panel(it);
        final Procedure1<Panel> _function = new Procedure1<Panel>() {
          public void apply(final Panel it) {
            VerticalLayout _verticalLayout = new VerticalLayout();
            it.setLayout(_verticalLayout);
            ControlDeGastosWindow.this.panelPresentacion(it);
            ControlDeGastosWindow.this.panelBusqueda(it);
            ControlDeGastosWindow.this.panelTablaDeGastos(it);
          }
        };
        final Panel panelIzquierdo = ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
        Panel _panel_1 = new Panel(it);
        final Procedure1<Panel> _function_1 = new Procedure1<Panel>() {
          public void apply(final Panel it) {
            VerticalLayout _verticalLayout = new VerticalLayout();
            it.setLayout(_verticalLayout);
            ControlDeGastosWindow.this.panelNuevoGasto(it);
          }
        };
        final Panel panelDerecho = ObjectExtensions.<Panel>operator_doubleArrow(_panel_1, _function_1);
      }
    };
    ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel panelPresentacion(final Panel miPanel) {
    Panel _xblockexpression = null;
    {
      this.panelUsuario(miPanel);
      _xblockexpression = this.panelTotalGastado(miPanel);
    }
    return _xblockexpression;
  }
  
  public Panel panelUsuario(final Panel miPanel) {
    Panel _panel = new Panel(miPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        ControlDeGastosWindow.this.titulo(it, "Hola! ");
        Label _label = new Label(it);
        final Procedure1<Label> _function = new Procedure1<Label>() {
          public void apply(final Label it) {
            ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
            ArenaXtendExtensions.operator_spaceship(_value, "usuario.nombre");
            it.setFontSize(14);
          }
        };
        ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
        ControlDeGastosWindow.this.titulo(it, " estos son tus gastos");
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel panelTotalGastado(final Panel miPanel) {
    Panel _panel = new Panel(miPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        ControlDeGastosWindow.this.subtitulo(it, "Llevas gastado: ");
        ControlDeGastosWindow.this.labelBinding(it, "totalDeGastos");
        ControlDeGastosWindow.this.subtitulo(it, " en total");
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel panelBusqueda(final Panel miPanel) {
    Panel _xblockexpression = null;
    {
      this.panelDeBusquedaDeDescripcion(miPanel);
      _xblockexpression = this.panelFiltrar(miPanel);
    }
    return _xblockexpression;
  }
  
  public Panel panelFiltrar(final Panel miPanel) {
    Panel _panel = new Panel(miPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        Button _button = new Button(it);
        final Procedure1<Button> _function = new Procedure1<Button>() {
          public void apply(final Button it) {
            it.setCaption("Filtrar");
            final Action _function = new Action() {
              public void execute() {
                AppModelControlGastos _modelObject = ControlDeGastosWindow.this.getModelObject();
                _modelObject.buscarDescripcion();
              }
            };
            it.onClick(_function);
          }
        };
        ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
        ControlDeGastosWindow.this.subtitulo(it, "Gastos de la descripcion Buscada = ");
        ControlDeGastosWindow.this.labelBinding(it, "totalDeDescripcionBuscada");
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel panelDeBusquedaDeDescripcion(final Panel miPanel) {
    Panel _panel = new Panel(miPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        ControlDeGastosWindow.this.subtitulo(it, "Filtrar por Descripcion: ");
        ControlDeGastosWindow.this.busqueda(it, "busquedaDescripcion");
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel panelNuevoGasto(final Panel miPanel) {
    Panel _xblockexpression = null;
    {
      Panel _panel = new Panel(miPanel);
      final Procedure1<Panel> _function = new Procedure1<Panel>() {
        public void apply(final Panel it) {
          ControlDeGastosWindow.this.titulo(it, "Nuevo Gasto");
          ControlDeGastosWindow.this.subtitulo(it, "Descripcion");
          ControlDeGastosWindow.this.busqueda(it, "nuevaDescripcion");
          ControlDeGastosWindow.this.subtitulo(it, "Monto");
          ControlDeGastosWindow.this.busqueda(it, "nuevoMonto");
        }
      };
      ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
      Panel _panel_1 = new Panel(miPanel);
      final Procedure1<Panel> _function_1 = new Procedure1<Panel>() {
        public void apply(final Panel it) {
          Button _button = new Button(it);
          final Procedure1<Button> _function = new Procedure1<Button>() {
            public void apply(final Button it) {
              it.setCaption("Agregar");
              final Action _function = new Action() {
                public void execute() {
                  AppModelControlGastos _modelObject = ControlDeGastosWindow.this.getModelObject();
                  _modelObject.agregarNuevaCalificacion();
                }
              };
              it.onClick(_function);
            }
          };
          ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
        }
      };
      _xblockexpression = ObjectExtensions.<Panel>operator_doubleArrow(_panel_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public Column<Gasto> panelTablaDeGastos(final Panel miPanel) {
    Column<Gasto> _xblockexpression = null;
    {
      Table<Gasto> _table = new Table<Gasto>(miPanel, Gasto.class);
      final Procedure1<Table<Gasto>> _function = new Procedure1<Table<Gasto>>() {
        public void apply(final Table<Gasto> it) {
          ViewObservable<Table<Gasto>, TableBuilder<Gasto>> _items = it.items();
          ArenaXtendExtensions.operator_spaceship(_items, "buscarDescripcion");
          ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
          ArenaXtendExtensions.operator_spaceship(_value, "gastoSeleccionado");
          it.setNumberVisibleRows(10);
        }
      };
      final Table<Gasto> table = ObjectExtensions.<Table<Gasto>>operator_doubleArrow(_table, _function);
      _xblockexpression = this.descripcionDeLaTabla(table);
    }
    return _xblockexpression;
  }
  
  public Column<Gasto> descripcionDeLaTabla(final Table<Gasto> table) {
    Column<Gasto> _xblockexpression = null;
    {
      Column<Gasto> _column = new Column<Gasto>(table);
      final Procedure1<Column<Gasto>> _function = new Procedure1<Column<Gasto>>() {
        public void apply(final Column<Gasto> it) {
          it.setTitle("Mes");
          it.setFixedSize(150);
          it.bindContentsToProperty("fecha");
        }
      };
      ObjectExtensions.<Column<Gasto>>operator_doubleArrow(_column, _function);
      Column<Gasto> _column_1 = new Column<Gasto>(table);
      final Procedure1<Column<Gasto>> _function_1 = new Procedure1<Column<Gasto>>() {
        public void apply(final Column<Gasto> it) {
          it.setTitle("Descripcion");
          it.setFixedSize(150);
          it.bindContentsToProperty("descripcion");
        }
      };
      ObjectExtensions.<Column<Gasto>>operator_doubleArrow(_column_1, _function_1);
      Column<Gasto> _column_2 = new Column<Gasto>(table);
      final Procedure1<Column<Gasto>> _function_2 = new Procedure1<Column<Gasto>>() {
        public void apply(final Column<Gasto> it) {
          it.setTitle("Monto");
          it.setFixedSize(150);
          it.bindContentsToProperty("monto");
        }
      };
      _xblockexpression = ObjectExtensions.<Column<Gasto>>operator_doubleArrow(_column_2, _function_2);
    }
    return _xblockexpression;
  }
  
  public Panel titulo(final Panel miPanel, final String unTitulo) {
    Panel _panel = new Panel(miPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        Label _label = new Label(it);
        final Procedure1<Label> _function = new Procedure1<Label>() {
          public void apply(final Label it) {
            it.setText(unTitulo);
            it.setFontSize(14);
          }
        };
        ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel subtitulo(final Panel miPanel, final String unSubtitulo) {
    Panel _panel = new Panel(miPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        Label _label = new Label(it);
        final Procedure1<Label> _function = new Procedure1<Label>() {
          public void apply(final Label it) {
            it.setText(unSubtitulo);
          }
        };
        ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Panel busqueda(final Panel busquedaPanel, final String unBinding) {
    Panel _panel = new Panel(busquedaPanel);
    final Procedure1<Panel> _function = new Procedure1<Panel>() {
      public void apply(final Panel it) {
        HorizontalLayout _horizontalLayout = new HorizontalLayout();
        it.setLayout(_horizontalLayout);
        TextBox _textBox = new TextBox(it);
        final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
          public void apply(final TextBox it) {
            ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
            ArenaXtendExtensions.operator_spaceship(_value, unBinding);
            it.setWidth(200);
          }
        };
        ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
      }
    };
    return ObjectExtensions.<Panel>operator_doubleArrow(_panel, _function);
  }
  
  public Label labelBinding(final Panel miPanel, final String unBinding) {
    Label _label = new Label(miPanel);
    final Procedure1<Label> _function = new Procedure1<Label>() {
      public void apply(final Label it) {
        ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
        ArenaXtendExtensions.operator_spaceship(_value, unBinding);
      }
    };
    return ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
  }
}
