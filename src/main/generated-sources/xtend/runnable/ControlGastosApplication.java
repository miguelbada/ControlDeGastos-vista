package runnable;

import appModel.AppModelControlGastos;
import model.Usuario;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import ui.ControlDeGastosWindow;
import usuarioDummy.UsuarioDummy;

@SuppressWarnings("all")
public class ControlGastosApplication extends Application {
  protected Window<?> createMainWindow() {
    ControlDeGastosWindow _xblockexpression = null;
    {
      AppModelControlGastos _appModelControlGastos = new AppModelControlGastos();
      final Procedure1<AppModelControlGastos> _function = new Procedure1<AppModelControlGastos>() {
        public void apply(final AppModelControlGastos it) {
          UsuarioDummy _usuarioDummy = new UsuarioDummy();
          Usuario _usuario = _usuarioDummy.getUsuario();
          it.setUsuario(_usuario);
        }
      };
      final AppModelControlGastos model = ObjectExtensions.<AppModelControlGastos>operator_doubleArrow(_appModelControlGastos, _function);
      _xblockexpression = new ControlDeGastosWindow(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    ControlGastosApplication _controlGastosApplication = new ControlGastosApplication();
    _controlGastosApplication.start();
  }
}
