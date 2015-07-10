package techreborn.asm;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import techreborn.lib.ModInfo;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.7.10")
public class LoadingPlugin implements IFMLLoadingPlugin {

	public static boolean runtimeDeobfEnabled = false;
	public static int stripedClases = 0;

	@Override
	public String[] getASMTransformerClass() {
		return new String[]{"techreborn.asm.ClassTransformation"};
	}

	@Override
	public String getModContainerClass() {
		return DummyMod.class.getName();
	}

	@Override
	public String getSetupClass() {
		return DummyMod.class.getName();
	}

	@Override
	public void injectData(Map<String, Object> data) {
		runtimeDeobfEnabled = (Boolean) data.get("runtimeDeobfuscationEnabled");
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

	public static class DummyMod extends DummyModContainer implements IFMLCallHook {
		public DummyMod() {
			super(new ModMetadata());
			ModMetadata md = getMetadata();
			md.autogenerated = true;
			md.modId = ModInfo.MOD_ID + "asm";
			md.name = md.description = "Techreborn-ASM";
			md.parent = ModInfo.MOD_ID;
			md.version = "000";
		}

		@Override
		public void injectData(Map<String, Object> data) {

		}

		@Override
		public Void call() throws Exception {
			return null;
		}
	}
}
