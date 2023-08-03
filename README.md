# Install requirements
```
pip install torch==1.13.1+rocm5.2 torchvision==0.14.1+rocm5.2 torchaudio==0.13.1 --extra-index-url https://download.pytorch.org/whl/rocm5.2
pip install -r requirements.txt
```

# Start the training
```
deepspeed --master_port 2428 main.py configs/train_deepspeed.json # Run with deepspeed
```
```
python main.py configs/train.json # Run without deepspeed
```

