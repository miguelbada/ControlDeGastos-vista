package runnable

import org.uqbar.arena.Application
import appModel.AppModelControlGastos
import usuarioDummy.UsuarioDummy
import ui.ControlDeGastosWindow

class ControlGastosApplication extends Application {
	override protected createMainWindow() {
		val model = new AppModelControlGastos => [
			usuario = new UsuarioDummy().usuario
			]
		new ControlDeGastosWindow(this, model) 
	}
	
	def static void main(String[] args) {
		new ControlGastosApplication().start()
	}	
	
}