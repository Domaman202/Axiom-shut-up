package ru.cws.mixin.client;

import com.moulberry.axiom.utils.BooleanWrapper;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(com.moulberry.axiom.ClientEvents.class)
public class ClientEventsMixin {
	@Shadow(remap = false)
    public static boolean serverSupportsAxiom;
	@Shadow(remap = false)
	public static boolean allowedOnServer;

	@Inject(method = "lambda$register$22", at = @At(value = "INVOKE", target = "Lcom/moulberry/axiom/Restrictions;reset()V", shift = At.Shift.AFTER), remap = false)
	private static void register1(BooleanWrapper contextMenuDown, MinecraftClient client, CallbackInfo ci) {
//		serverSupportsAxiom = true;
		allowedOnServer = true;
	}


	@Inject(method = "lambda$register$22", at = @At(value = "INVOKE", target = "Ljava/util/EnumSet;contains(Ljava/lang/Object;)Z", shift = At.Shift.AFTER), remap = false)
	private static void register2(BooleanWrapper contextMenuDown, MinecraftClient client, CallbackInfo ci) {
//		serverSupportsAxiom = true;
		allowedOnServer = true;
	}

	@Inject(method = "lambda$register$22", at = @At(value = "INVOKE", target = "Ljava/net/InetSocketAddress;getHostString()Ljava/lang/String;", shift = At.Shift.AFTER), remap = false)
	private static void register3(BooleanWrapper contextMenuDown, MinecraftClient client, CallbackInfo ci) {
//		serverSupportsAxiom = true;
		allowedOnServer = true;
	}

	@Inject(method = "<clinit>", at = @At("TAIL"), remap = false)
    private static void clinit(CallbackInfo ci) {
//		serverSupportsAxiom = true;
		allowedOnServer = true;
	}
}